package ru.yoursolution.servermodule.okhttp;

/**
 * Created by Admin on 15.12.2016.
 */

import android.util.Base64;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import ru.yoursolution.servermodule.Time;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static ru.yoursolution.servermodule.Time.getCurrentTime;

public class OkHttpTest {

    public static List<String> log = new ArrayList<>();

    private OkHttpClient client;
    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
            .retryOnConnectionFailure(true).readTimeout(2000, TimeUnit.MILLISECONDS)
            .writeTimeout(2000, TimeUnit.MILLISECONDS).followRedirects(true)
            .connectTimeout(2000, TimeUnit.MILLISECONDS);
    private String url;


    // code request code here
    String doGetAuthRequest(String url, String userName, String password) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", toBase64(userName, password))
                .build();

        String string = headersToString(request);
        System.out.println(string);

        Response response = null;
        try {
            response = client.newCall(request).execute();
            log.add("response");
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            log.add("\n" + getCurrentTime() + "exception: " + e.getMessage());
        }
        return "";
    }

    String doGetRequest(String url){
        log.add("start request");
        Request request = new Request.Builder()
                .url(url)
                .build();
        log.add("request built");
        log.add("\n" + getCurrentTime() + "request:" + bodyToString(request));
        Response response = null;
        try {
            response = client.newCall(request).execute();
            log.add("response");
            return response.toString() + "\n" + response.body().string() + "\n\n";
        } catch (Exception e) {
            e.printStackTrace();
            log.add("\n" + getCurrentTime() + "exception: " + e.getMessage() + "\n\n");
        }
        return "";
    }

    String doCurveGetRequest(String url, String userName, String password) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", toBase64(userName, password))
                .build();
        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                try {
                    log.add("\n" + getCurrentTime() + ": push first request");
                    Response response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.add("\n" + e.getMessage());
                }
            }
        });
        thread.start();
        try {
            log.add("\n" + getCurrentTime() + "sleep");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.add("\n" + getCurrentTime() + "sleep exception" + e.getMessage());
        }
        client.newCall(request).cancel();
        Request request2 = new Request.Builder()
                .url(url)
                .addHeader("Authorization", toBase64(userName, password))
                .build();
        /*Authorization: Basic 0JDQtNC80LjQvdC40YHRgtGA0LDRgtC+0YA6MQ==
        Upgrade-Insecure-Requests: 1
        Referer: http://moon/Test/odata/standard.odata?$format=application/json*/
        log.add("\n" + getCurrentTime() + "Auth" + request2.toString() + "\n" + request2.headers().toString());
        Response response = null;
        try {
            client = httpClientBuilder.build();
            log.add("\n" + getCurrentTime() + "push second request");
            log.add("\n" + getCurrentTime() + "request:" + bodyToString(request2));
            response = client.newCall(request2).execute();
            log.add("\n" + getCurrentTime() + "response");
            return response.toString() + "\n" + response.body().string() + "\n\n";
        } catch (IOException e) {
            e.printStackTrace();
            log.add("\n" + getCurrentTime() + "exception: " + e.getMessage()+ "\n\n");
        }
        return "";
    }

    // post request code here

    public final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    // test data
    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }

    String doPostRequest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public String test() {
        client = httpClientBuilder.build();
        //client = addAuthInterceptor("Администратор", "1");
        // issue the Get request
        //String getResponse = doGetRequest("http://www.vogella.com");

        System.out.println("get");
        String url = "http://moon/Test/odata/standard.odata?$format=application/json";
        String getResponse = doGetAuthRequest(url, "Администратор", "1");
        System.out.println(getResponse);

        // issue the post request

        /*System.out.println("post");
        String json = bowlingJson("Jesse", "Jake");
        String postResponse = doPostRequest("http://www.roundsapp.com/post", json);
        System.out.println(postResponse);*/
        return getResponse + "\n" /*+ postResponse*/;
    }

    public String testAuthMoon() throws IOException{
        log.clear();
        log.add("\n" + getCurrentTime() + "start");
        //client = httpClientBuilder.build();
        addInterceptorsToBuilder();
        httpClientBuilder.addInterceptor(new HttpLoggingInterceptor(new MyLogging()).setLevel(BODY));
        //client = addAuthInterceptor("Администратор", "1").build();
        client = httpClientBuilder.addInterceptor(new AuthInterceptor("Администратор", "1")).build();
        String url = "http://moon/Test/odata/standard.odata?$format=application/json";
        log.add("\n" + getCurrentTime() + "resp" + doGetRequest(url));
        return log.toString();
    }

    public String testMoon() throws IOException{
        log.clear();
        log.add("\n" + getCurrentTime() + "start");
        //client = httpClientBuilder.build();
        //addAuthInterceptor("Администратор", "1");
        httpClientBuilder.addInterceptor(new HttpLoggingInterceptor(new MyLogging()).setLevel(BODY));
        client =addInterceptorsToBuilder().build();
        String url = "http://moon/Test/odata/standard.odata?$format=application/json";
        //log.add("\nresp" + doCurveGetRequest(url, "Администратор", "1"));
        log.add("\n" + getCurrentTime() + "resp" + doGetRequest(url));
        return log.toString();
    }

    public String local() throws IOException{
        log.clear();
        log.add("start");
        //client = httpClientBuilder.build();
        httpClientBuilder.addInterceptor(new HttpLoggingInterceptor(new MyLogging()).setLevel(BODY));
        client =addInterceptorsToBuilder().build();
        String url = "http://192.168.1.1";
        log.add("\n" + getCurrentTime() + "resp" + doGetRequest(url));
        return log.toString();
    }

    public String testAuthGitHub() throws IOException{
        log.clear();
        url = "https://api.github.com/user";
        //client = httpClientBuilder.build();

        addInterceptorsToBuilder();
        httpClientBuilder.addInterceptor(new HttpLoggingInterceptor(new MyLogging()).setLevel(BODY));
        client = addAuthInterceptor("roman-nevr", "zaq12wsx").build();
        //client = buildInterceptedClient();
        //client = addAuthInterceptor("Администратор", "1");
        //return doGetAuthRequest("https://api.github.com/user", "roman-nevr", "zaq12wsx");
        log.add("\n" + getCurrentTime() + "resp" + doGetRequest(url));
        return log.toString();
    }

    private String toBase64(final String username, final String password){
        String credentials = username + ":" + password;
        return "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
    }

    public OkHttpClient.Builder addAuthInterceptor(final String username, final String password) {
        return httpClientBuilder.authenticator(new MyAuth(username, password));
    }

    public OkHttpClient.Builder addInterceptorsToBuilder(){
        OkHttpClient.Builder builder = httpClientBuilder.addNetworkInterceptor(new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                log.add("\n" + getCurrentTime() + "network, headers: " + chain.request().headers().toString());
                log.add("\n" + getCurrentTime() + " request" + chain.request().toString());
                Response response = chain.proceed(chain.request());
                log.add("\n" + getCurrentTime() + " response: " + response.headers().toString() + "\n" + response.body().string() + "\n\n");
                log.add("\n" + getCurrentTime() + " code" + response.code());
                return response;
            }
        });
        builder.addInterceptor(new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                log.add("\n" + getCurrentTime() + "intercept, headers: " + chain.request().headers().toString());
                log.add("\n" + getCurrentTime() + "chain " + chain.request().toString());
                Response response = chain.proceed(chain.request());
                log.add("\n" + getCurrentTime() + "response: " + response.headers().toString() + "\n" + response.body().string() + "\n\n");
                log.add("\n" + getCurrentTime() + "code" + response.code());
                return response;
            }
        });
        return builder;
    }

    private class AuthInterceptor implements Interceptor {
        private String username, password;

        public AuthInterceptor(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override public Response intercept(Chain chain) throws IOException {
            String credentials = username + ":" + password;
            String credential = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            log.add("\n" + getCurrentTime() + ": cred " + credential);
            log.add("\n" + getCurrentTime() + ": request: " + chain.request());
            Request request = chain.request().newBuilder()
                    .header("Authorization", credential).build();
            Response response = chain.proceed(request);
            log.add("\n" + getCurrentTime() + ": response: " + response);
            //Credentials.basic(username, password);
            log.add("\n" + getCurrentTime() + ": headres: " + response.headers().toString());
            return response;
        }
    }

    private static String bodyToString(final Request request){

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            buffer.writeString(copy.headers().toString(), Charset.defaultCharset());
            return buffer.readUtf8();
        } catch (final Exception e) {
            return "did not work";
        }
    }

    private static String headersToString(final Request request){

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            return copy.headers().toString();
        } catch (Exception e) {
            return "did not work";
        }
    }

    private class MyAuth implements Authenticator{
        private String username, password;

        public MyAuth(String username, String password) {
            this.username = username;
            this.password = password;
        }
        @Override public Request authenticate(Route route, Response response) throws IOException {
            log.add("\n" + getCurrentTime() + ": auth");
            String credentials = username + ":" + password;
            String credential = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            log.add("\n" + getCurrentTime() + ": cred " + credential);
            log.add("\n" + getCurrentTime() + ": request: " + response.request());
            log.add("\n" + getCurrentTime() + ": response: " + response);
            //Credentials.basic(username, password);
            log.add("\n" + getCurrentTime() + ": headres: " + response.headers().toString());
            Request request = response.request().newBuilder()
                    .header("Authorization", credential)
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Referer", response.request().url().toString())
                    .build();
            log.add("\n" + getCurrentTime() + ": final request: " + request);
            log.add("\n" + getCurrentTime() + ": headers" + request.headers().toString());
            return request;
        }
    }

    private class MyLogging implements HttpLoggingInterceptor.Logger{
        @Override public void log(String message) {
            log.add("\n" + message);
        }
    }
}