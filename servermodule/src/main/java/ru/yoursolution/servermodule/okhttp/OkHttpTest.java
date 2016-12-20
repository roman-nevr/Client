package ru.yoursolution.servermodule.okhttp;

/**
 * Created by Admin on 15.12.2016.
 */

import android.app.Application;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import okhttp3.Route;
import okio.Buffer;

public class OkHttpTest {

    public static List<String> log = new ArrayList<>();

    private OkHttpClient client;
    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
            .retryOnConnectionFailure(false);
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
            log.add("\nexception: " + e.getMessage());
        }
        return "";
    }

    String doGetRequest(String url){
        log.add("start request");
        Request request = new Request.Builder()
                .url(url)
                .build();
        log.add("request built");
        String string = headersToString(request);
        System.out.println(string);

        Response response = null;
        try {
            response = client.newCall(request).execute();
            log.add("response");
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            log.add("\nexception: " + e.getMessage());
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
        //client = buildAuthClient("Администратор", "1");
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
        log.add("start");
        //client = httpClientBuilder.build();
        client = buildAuthClient("Администратор", "1");
        String url = "http://moon/Test/odata/standard.odata?$format=application/json";
        log.add("\nresp" + doGetRequest(url));
        return log.toString();
    }

    public String testMoon() throws IOException{
        log.clear();
        log.add("start");
        //client = httpClientBuilder.build();
        client = new OkHttpClient();
        String url = "http://moon/Test/odata/standard.odata?$format=application/json";
        log.add("\nresp" + doGetRequest(url));
        return log.toString();
    }

    public String testAuthGitHub() throws IOException{
        log.clear();
        url = "https://api.github.com/user";
        //client = httpClientBuilder.build();
        //client = buildAuthClient("roman-nevr", "zaq12wsx");
        client = buildInterceptedClient();
        //return doGetAuthRequest("https://api.github.com/user", "roman-nevr", "zaq12wsx");
        log.add("\nresp" + doGetRequest(url));
        return log.toString();
    }

    private String toBase64(final String username, final String password){
        String credentials = username + ":" + password;
        return "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
    }

    public OkHttpClient buildAuthClient(final String username, final String password) {
        return httpClientBuilder.authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                log.add("auth");
                String credentials = username + ":" + password;
                String credential = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                log.add("cred " + credential);
                log.add("\nrequest: " + response.request());
                log.add("\nresponse: " + response);
                //Credentials.basic(username, password);
                log.add("\nheadres: " + response.headers().toString());
                Request request = response.request().newBuilder()
                        .header("Authorization", credential)
                        .build();
                log.add("\nfinal request: " + request);
                log.add("\nheaders" + request.headers().toString());
                return request;
            }
        }).build();
    }

    public OkHttpClient buildInterceptedClient(){
        OkHttpClient.Builder builder = httpClientBuilder.addNetworkInterceptor(new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                log.add("\nnetwork" + chain.request().headers().toString());
                return chain.proceed(chain.request());
            }
        });
        builder.addInterceptor(new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                log.add("\nnetwork" + chain.request().headers().toString());
                return chain.proceed(chain.request());
            }
        });
        return builder.build();
    }

    private static String bodyToString(final Request request){

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
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
}