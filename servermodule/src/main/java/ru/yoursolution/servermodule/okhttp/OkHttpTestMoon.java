package ru.yoursolution.servermodule.okhttp;

/**
 * Created by Admin on 15.12.2016.
 */

import android.util.Base64;

import java.io.IOException;
import java.net.SocketTimeoutException;
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

public class OkHttpTestMoon {

    public static List<String> log = new ArrayList<>();

    private OkHttpClient client;
    private OkHttpClient.Builder httpClientBuilder = getBuilder();
    private String url;

    private static OkHttpClient.Builder getBuilder(){
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true).readTimeout(1000, TimeUnit.MILLISECONDS)
                .writeTimeout(1000, TimeUnit.MILLISECONDS).followRedirects(true)
                .connectTimeout(1000, TimeUnit.MILLISECONDS);
    }

    public static OkHttpClient.Builder getClientBuilder(){
        return getBuilder().addInterceptor(new AuthInterceptor("Администратор", "1"));
    }

    // code request code here

    private String doGetRequest(String url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();
        /*Response response = null;
        try {
            response = client.newCall(request).execute();
            log.add("response");
            return response.toString() + "\n" + response.body().string() + "\n\n";
        } catch (Exception e) {
            e.printStackTrace();
            log.add("\n" + getCurrentTime() + "exception: " + e.getMessage() + "\n\n");
        }
        return "";*/
        /*Response response = client.newCall(request).execute();
        return response.body().toString();*/
        Response response = null;
        try {
            response = executeResponse(request);
        }catch (IOException e){
            return e.getClass() + " : " + e.getMessage();
        }
        return response.body().string();
    }

    private Response executeResponse(Request request) throws IOException {
        Response response = null;
        try {
            response = client.newCall(request).execute();
        }catch (SocketTimeoutException e){
            //костыль для IIS
            response = client.newCall(request).execute();
        }
        return response;
    }

    // post request code here

    public String testAuthMoon() throws IOException{
        client = httpClientBuilder.addInterceptor(new AuthInterceptor("Администратор", "1")).build();
        url = "http://moon/Test/odata/standard.odata?$format=application/json";
        return doGetRequest(url);
    }

    public final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private String toBase64(final String username, final String password){
        String credentials = username + ":" + password;
        return "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
    }
    private static class AuthInterceptor implements Interceptor {
        private String username, password;

        public AuthInterceptor(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override public Response intercept(Chain chain) throws IOException {
            String credentials = username + ":" + password;
            String credential = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            Request request = chain.request().newBuilder()
                    .header("Authorization", credential).build();
            Response response = chain.proceed(request);
            return response;
        }
    }

}