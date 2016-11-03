package ru.rubicon.client.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import ru.rubicon.client.R;
import ru.rubicon.client.interfaces.IGithubPresenter;

/**
 * Created by Витя on 31.10.2016.
 */

public class GithubActivity extends AppCompatActivity implements {

    Button btnGitGetUser, btnGitGetContributor;
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
        btnGitGetUser = (Button) findViewById(R.id.btnGitGetUser);
        btnGitGetContributor = (Button) findViewById(R.id.btnGitGetContributor);
        tvGit = (TextView) findViewById(R.id.tvGit);
        etUserName = (EditText) findViewById(R.id.etUserName);
        btnGitGetUser.setOnClickListener(new ButtonGitOnClickListener());
        btnGitGetContributor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private class ButtonGitOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            presenter.getUser(etUserName.getText().toString());
        }

    }
}
