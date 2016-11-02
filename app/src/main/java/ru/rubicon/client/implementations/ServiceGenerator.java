package ru.rubicon.client.implementations;

/**
 * Created by Витя on 01.11.2016.
 */

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import ru.rubicon.client.model.GitModel;

public class ServiceGenerator {
    public static final String API_BASE_URL = "https://api.github.com/";

    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }

    public interface GitAPI {
        @GET("/users/{user}")
        Call<GitModel> user(
                @Path("user") String user
        );
    }
}
