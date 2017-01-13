package ru.rubicon.client.data;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.rubicon.client.model.odata.Metadata;
import ru.yoursolution.servermodule.okhttp.OkHttpTestMoon;
import rx.Observable;

import static ru.rubicon.client.Basement.logger;

/**
 * Created by Admin on 14.12.2016.
 */

public class MoonServiceGenerator {
    public static final String API_BASE_URL = "http://moon/Test/odata/standard.odata/";
    private static final OkHttpClient.Builder httpClientBuilder =
            OkHttpTestMoon.getClientBuilder();
    private static final String FORMAT = "?$format=application/json";


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory
                            .create(/*new GsonBuilder()
                    .setLenient().create()*/));

    public static <S> S createService(Class<S> serviceClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
                message -> logger.log(message))
                .setLevel(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient.Builder httpBuilder = httpClientBuilder.addInterceptor(interceptor);

        Retrofit retrofit = builder.client(httpBuilder.build()).build();
        return retrofit.create(serviceClass);
    }

    public interface MoonApi {
        @GET(FORMAT)
        Call<Metadata> metadata();

        @GET(FORMAT)
        Observable<Metadata> rxMetadata();

        @GET("{url}" + FORMAT)
        Call<ResponseBody> data(@Path("url") String url);

        /*@GET("Document_РасходныйОрдер" + FORMAT)
        Call<NomenclatureElement>*/
    }
}
