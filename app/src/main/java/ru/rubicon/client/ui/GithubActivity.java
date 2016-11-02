package ru.rubicon.client.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.rubicon.client.R;
import ru.rubicon.client.implementations.ServiceGenerator;
import ru.rubicon.client.implementations.ServiceGenerator.GitAPI;
import ru.rubicon.client.interfaces.IGithubPresenter;
import ru.rubicon.client.model.GitModel;

/**
 * Created by Витя on 31.10.2016.
 */

public class GithubActivity extends AppCompatActivity {

    Button btnGit;
    TextView tvGit;
    EditText etUserName;

    @Inject
    IGithubPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.git_activity);
        btnGit = (Button) findViewById(R.id.btnGit);
        tvGit = (TextView) findViewById(R.id.tvGit);
        etUserName = (EditText) findViewById(R.id.etUserName);

        btnGit.setOnClickListener(new ButtonGitOnClickListener());
    }

    private class ButtonGitOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            presenter.getResponse(etUserName.getText().toString());
        }

    }
}
