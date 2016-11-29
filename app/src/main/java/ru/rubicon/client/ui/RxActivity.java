package ru.rubicon.client.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import ru.rubicon.client.R;
import ru.rubicon.client.interfaces.RxConvention;
import ru.rubicon.client.ui.presenters.RxActivityPresenterImpl;

/**
 * Created by Admin on 29.11.2016.
 */

public class RxActivity extends AppCompatActivity implements RxConvention.IRxActivityView {

    @Bind(R.id.tvText)TextView tvText;
    @Bind(R.id.btnAdd)Button btnAdd;
    @Bind(R.id.etName)EditText etName;
    @Bind(R.id.rlShadowRx)RelativeLayout rlShadow;

    private RxConvention.IRxActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_activity_layout);
        presenter = new RxActivityPresenterImpl(this);
    }

    @Override
    public void setText(String text) {
        tvText.setText(text);
    }

    @Override
    public void addText(String text) {
        tvText.setText(tvText.getText().toString() + "\n" + text);
    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public void showProgress() {
        rlShadow.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        rlShadow.setVisibility(View.GONE);
    }

    @Override
    public Button getAddButton() {
        return btnAdd;
    }

    @Override
    public EditText getEditText() {
        return etName;
    }
}
