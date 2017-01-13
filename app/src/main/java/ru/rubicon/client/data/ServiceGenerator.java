package ru.rubicon.client.data;

/**
 * Created by Витя on 01.11.2016.
 */

import android.util.Base64;
import android.util.Log;


import java.io.IOException;
import java.util.List;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.rubicon.client.model.git.Gist;
import ru.rubicon.client.model.git.GitUser;

public class ServiceGenerator {
    public static final String API_BASE_URL = "https://api.github.com/";
    private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClientBuilder.build()).build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, final String username, final String password) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("okHTTP", message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder.addInterceptor(interceptor);
        if (username != null && password != null) {
            String credentials = username + ":" + password;
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);


        }
        OkHttpClient httpClient = httpClientBuilder.authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                String credential = Credentials.basic(username, password);
                return response.request().newBuilder()
                        .header("Authorization", credential)
                        .build();
            }
        }).build();
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }



    public interface GitAPI {
        @GET("/users/{user}")
        Call<GitUser> user(
                @Path("user") String user
        );
        @GET("/repos/{owner}/{repo}/contributors")
        Call<List<Contributor>> contributors(
                @Path("owner") String owner,
                @Path("repo") String repo);
        @GET("/user")
        Call<GitUser> basicLogin();
        @GET("/user/emails")
        Call<List<GitUser>> getEmails();
        @POST ("/gists")
        Call<Gist>createGist(@Body Gist gist);

    }

    public class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(String login, int contributions) {
            this.login = login;
            this.contributions = contributions;
        }
    }

}
