package ru.rubicon.client.data;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.rubicon.client.model.odata.Metadata;
import ru.rubicon.client.model.odata.MetadataValue;
import ru.rubicon.client.model.odata.odinesnik.Client;
import ru.rubicon.client.model.odata.odinesnik.Document;
import ru.rubicon.client.model.odata.OdataMetadata;
import ru.yoursolution.servermodule.okhttp.OdinesnikHttpClient;
import rx.Observable;

import static ru.rubicon.client.Basement.logger;

/**
 * Created by Admin on 14.12.2016.
 */

public class OdinesnikServiceGenerator {
    public static final String API_BASE_URL = "http://server.odinesnik.ru/post/odata/standard.odata/";
    private static final OkHttpClient.Builder httpClientBuilder =
            OdinesnikHttpClient.getClientBuilder();
    private static final String FORMAT_JSON = "?$format=application/json";
    private static final String FORMAT = "format";
    private static final String JSON = "application/json";


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory
                            .create());

    public static <S> S createService(Class<S> serviceClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
                message -> logger.log(message))
                .setLevel(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient.Builder httpBuilder = httpClientBuilder.addInterceptor(interceptor);

        Retrofit retrofit = builder.client(httpBuilder.build()).build();
        return retrofit.create(serviceClass);
    }

    public interface OdinesnikApi {
        @GET(FORMAT_JSON)
        Call<Metadata> metadata();

        @GET(FORMAT_JSON)
        Observable<OdataMetadata<MetadataValue>> rxMetadata();

        @GET("{url}" + FORMAT_JSON)
        Call<ResponseBody> data(@Path("url") String url);

        @GET("Catalog_Контрагенты"+FORMAT_JSON)
        Observable<OdataMetadata<Client>> clients();

        @GET("Catalog_Контрагенты(guid'{guid}')"+FORMAT_JSON)
        Call<ResponseBody> client(@Path("guid") String key);

        @GET("Catalog_Контрагенты" + FORMAT_JSON)
        Observable<OdataMetadata<Client>> clientsFiltered(@Query("$filter") String oDataFilter);

        @PATCH("Catalog_Контрагенты(guid'{guid}')"+FORMAT_JSON)
        Call<ResponseBody> updateClient(@Path("guid") String key, @Body Client client);


        //?$filter=substringof('ПРД', Артикул)
        //&$filter=substringof('Чеб',Description)
        /*
        @GET("api.php")
Call<Model> getRoms_center(@Query("company_name") String name);
         */

        @POST("Catalog_Контрагенты"+FORMAT_JSON)
        Call<ResponseBody> newClient(@Body Client client);

        @POST("Document_Док(guid'{guid}')/Post()" + FORMAT_JSON)
        Call<ResponseBody> post(@Path("guid") String key);

        @GET("Document_Док" + FORMAT_JSON)
        Observable<OdataMetadata<Document>> documents();

        @GET("Document_Док(guid'{guid}')" + FORMAT_JSON)
        Call<Document> document(@Path("guid") String key);

        @PATCH("Document_Док(guid'{guid}')"+FORMAT_JSON)
        Call<ResponseBody> updateDocument(@Path("guid") String key, @Body Document client);
    }
}
