package ru.rubicon.client.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.rubicon.client.Basement;
import ru.rubicon.client.R;
import ru.rubicon.client.implementations.MoonServiceGenerator;
import ru.rubicon.client.implementations.adapters.MetadataAdapter;
import ru.rubicon.client.interfaces.IOnItemClick;
import ru.rubicon.client.model.Metadata;
import ru.yoursolution.servermodule.okhttp.MetaOData;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static ru.rubicon.client.Basement.logger;

/**
 * Created by Admin on 22.12.2016.
 */

public class MetadataUi extends AppCompatActivity implements IOnItemClick, View.OnClickListener{

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.tvError) TextView tvError;
    private boolean repeat = false;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metadata_ui_activity);
        ButterKnife.bind(this);
        tvError.setMovementMethod(new ScrollingMovementMethod());
        rxLoadData();
        /*Gson gson = new GsonBuilder().create();
        Metadata metadata = gson.fromJson(MetaOData.data, Metadata.class);*/
    }

    private void loadData() {
        MoonServiceGenerator.MoonApi moonApi = MoonServiceGenerator
                .createService(MoonServiceGenerator.MoonApi.class);

        Call<Metadata> call = moonApi.metadata();
        showProgress();
        call.enqueue(new Callback<Metadata>() {
            @Override public void onResponse(Call<Metadata> call,
                                             Response<Metadata> response) {
                hideProgress();
                recyclerView.setAdapter(new MetadataAdapter(response.body().getValue(),
                        MetadataUi.this));
                repeat = true;
            }

            @Override public void onFailure(Call<Metadata> call, Throwable t) {
                if (repeat == true){
                    repeat = false;
                    loadData();
                }else {
                    showError("\nrequest headers" + call.request().headers().toString()
                            + "\nerror" + t.getMessage());
                }
            }
        });
    }

    private void rxLoadData(){
        showProgress();
        MoonServiceGenerator.MoonApi moonApi = MoonServiceGenerator
                .createService(MoonServiceGenerator.MoonApi.class);
        moonApi.rxMetadata()
                .repeat(2)
                .subscribeOn(Schedulers.io())  // execute the call asynchronously
                .observeOn(AndroidSchedulers.mainThread())  // handle the results in the ui thread
                .subscribe(this::onComplete, this::onError);
    }

    private void onComplete(Metadata metadata) {
        hideProgress();
        recyclerView.setAdapter(new MetadataAdapter(metadata.getValue(),
                MetadataUi.this));
    }

    private void onError(Throwable throwable) {
        showError(throwable.getClass() + ":" + throwable.getMessage());
    }


    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    private void showError(String arg) {
        tvError.setVisibility(View.VISIBLE);
        tvError.setText(logger.print());
        logger.clear();
        hideProgress();
        snackBarLong(recyclerView, "Ошибочка вышла : " + arg);
    }

    private void showProgress() {
        tvError.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void onItemClickAction(View view, String url) {
        SimpleTextActivity.start(this, url);
    }

    public void snackBarLong(View view, String message){
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("Повтор", this);
        View snackbarView = snackbar.getView();
        TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(15);
        snackbar.show();
    }

    @Override public void onClick(View v) {
        logger.clear();
        rxLoadData();
    }
}
