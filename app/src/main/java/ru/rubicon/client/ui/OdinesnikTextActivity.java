package ru.rubicon.client.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.rubicon.client.R;
import ru.rubicon.client.data.OdinesnikServiceGenerator;
import ru.rubicon.client.model.odata.odinesnik.Client;
import ru.rubicon.client.model.odata.odinesnik.Document;
import ru.rubicon.client.model.odata.OdataMetadataError;

import static ru.rubicon.client.Basement.gson;
import static ru.rubicon.client.Basement.logger;

/**
 * Created by Admin on 22.12.2016.
 */

public class OdinesnikTextActivity extends AppCompatActivity {
    @BindView(R.id.tvText) TextView tvText;
    public static final String TEXT = "text";
    private OdinesnikServiceGenerator.OdinesnikApi api;
    private Client client;

    public static void start(Context context, String text) {
        Intent intent = new Intent(context, OdinesnikTextActivity.class);
        intent.putExtra(TEXT, text);
        context.startActivity(intent);
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_text_activity_layout);
        tvText = (TextView) findViewById(R.id.tvText);
        tvText.setMovementMethod(new ScrollingMovementMethod());
        api = OdinesnikServiceGenerator
                .createService(OdinesnikServiceGenerator.OdinesnikApi.class);
        //loadDataByKey(getIntent().getStringExtra(TEXT));
        loadUrl(getIntent().getStringExtra(TEXT));
        //loadDocument(getIntent().getStringExtra(TEXT));
    }

    private void loadDocument(String key) {
        Call<Document> call = api.document(key);
        call.enqueue(new Callback<Document>() {
            @Override
            public void onResponse(Call<Document> call, Response<Document> response) {
                try{
                    if(response.body() != null){
                        updateDocument(key, response.body());
                    }else {
                        showError(response.errorBody());
                    }
                }catch (IOException e){

                }

            }

            @Override
            public void onFailure(Call<Document> call, Throwable t) {

            }
        });
    }

    private void updateDocument(String key, Document document) {
        document.setDeletionMark(false);
        document.setPosted(true);
        Call<ResponseBody> call = api.updateDocument(key, document);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    if (response.body() != null){
                        String data = response.body().string();
                        if(data.equals("")){
                            tvText.setText("OK");
                        }else {
                            tvText.setText(data);
                        }
                    }else {
                        showError(response.errorBody());
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void loadUrl(String url) {
        Call<ResponseBody> call = api.data(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if(response.body() != null){
                        String data = response.body().string();
                        tvText.setText(data);
                        //client = new GsonBuilder().create().fromJson(data, Client.class);
                        //updateRecord(key);
                        //newRecord();
                    }else {
                        showError(response.errorBody());
                    }
                } catch (IOException e) {
                    showError("ошибка при парсинге ответа" + e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                tvText.setText(t.getMessage());
            }
        });
    }

    private void loadDataByKey(String key) {
        Call<ResponseBody> call = api.client(key);
        call.enqueue(new Callback<ResponseBody>() {
            @Override public void onResponse(Call<ResponseBody> call,
                                             Response<ResponseBody> response) {
                try {
                    if(response.body() != null){
                        String data = response.body().string();
                        tvText.setText(data);
                        client = gson.fromJson(data, Client.class);
                        //updateRecord(key);
                        //newRecord();
                    }else {
                        tvText.setText(response.errorBody().string());
                    }
                } catch (IOException e) {
                    showError("ошибка при парсинге ответа" + e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override public void onFailure(Call<ResponseBody> call, Throwable t) {
                showError("\nrequest headers" + call.request().headers().toString()
                        + "\nerror" + t.getClass() + t.getMessage());
            }
        });
    }

    private void newRecord(){
        client.setRefKey(Client.ZERO_KEY);
        client.setName(client.getName() + "-Android");
        Call<ResponseBody> call = api.newClient(client);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.body() != null){
                        String data = response.body().string();
                        System.out.println(data);
                        tvText.setText(tvText.getText() + "\n" + data);
                    }else if(response.errorBody() != null){
                        String data = response.errorBody().string();
                        System.out.println(data);
                        tvText.setText(tvText.getText() + "\n" + data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(t);
                tvText.setText(tvText.getText() + "\n" + t.getMessage());
            }
        });
    }

    private void updateRecord(String key) {
        client.setDeletionMark(true);
        client.setName(client.getName() + "123");
        Call<ResponseBody> call = api.updateClient(key, client);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String data = response.body().string();
                    System.out.println(data);
                    tvText.setText(tvText.getText() + "\n" + data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(t);
                tvText.setText(tvText.getText() + "\n" + t.getMessage());
            }
        });
    }

    private void showError(String arg) {
        tvText.setText(logger.print());
        snackBarLong(tvText, "Ошибочка вышла : " + arg);
    }

    public void snackBarLong(View view, String message){
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        View snackbarView = snackbar.getView();
        TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(15);
        snackbar.show();
    }

    private void showError(ResponseBody errorBody) throws IOException{
        String data = errorBody.string();
        System.out.println(data);
        OdataMetadataError error = gson.fromJson(data, OdataMetadataError.class);
        tvText.setText(error.getError().getCode() + ", " + error.getError().getMessage().getMessage());
    }
}
