package ru.rubicon.client.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
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
import ru.rubicon.client.implementations.MoonServiceGenerator;
import ru.rubicon.client.implementations.adapters.MetadataAdapter;
import ru.rubicon.client.model.Metadata;

import static ru.rubicon.client.Basement.logger;

/**
 * Created by Admin on 22.12.2016.
 */

public class SimpleTextActivity extends AppCompatActivity {
    @BindView(R.id.tvText) TextView tvText;
    public static final String TEXT = "text";

    public static void start(Context context, String text) {
        Intent intent = new Intent(context, SimpleTextActivity.class);
        intent.putExtra(TEXT, text);
        context.startActivity(intent);
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_text_activity_layout);
        tvText = (TextView) findViewById(R.id.tvText);
        tvText.setMovementMethod(new ScrollingMovementMethod());
        loadData(getIntent().getStringExtra(TEXT));

    }

    private void loadData(String url) {
        MoonServiceGenerator.MoonApi moonApi = MoonServiceGenerator
                .createService(MoonServiceGenerator.MoonApi.class);

        Call<ResponseBody> call = moonApi.data(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override public void onResponse(Call<ResponseBody> call,
                                             Response<ResponseBody> response) {
                try {
                    tvText.setText(response.body().string());
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
}
