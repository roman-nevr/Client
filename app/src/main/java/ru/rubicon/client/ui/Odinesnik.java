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

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.rubicon.client.R;
import ru.rubicon.client.data.OdinesnikServiceGenerator;
import ru.rubicon.client.implementations.adapters.MetadataAdapter;
import ru.rubicon.client.interfaces.IOnItemClick;
import ru.rubicon.client.model.odata.MetadataValue;
import ru.rubicon.client.model.odata.OdataMetadata;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static ru.rubicon.client.Basement.logger;

/**
 * Created by Admin on 12.01.2017.
 */

public class Odinesnik extends AppCompatActivity implements IOnItemClick, View.OnClickListener {

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

    private void rxLoadData(){
        showProgress();
        OdinesnikServiceGenerator.OdinesnikApi odinesnikApi = OdinesnikServiceGenerator
                .createService(OdinesnikServiceGenerator.OdinesnikApi.class);
        odinesnikApi.rxMetadata()
                .subscribeOn(Schedulers.io())  // execute the call asynchronously
                .observeOn(AndroidSchedulers.mainThread())  // handle the results in the ui thread
                .subscribe(this::onComplete, this::onError);
    }

    private void onComplete(OdataMetadata<MetadataValue> metadata) {
        hideProgress();
        recyclerView.setAdapter(new MetadataAdapter(metadata.getValues(),
                this));
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
        OdinesnikTextActivity.start(this, url);
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
