package ru.rubicon.client.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import ru.rubicon.client.di.Components.IGitHubComponent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import ru.rubicon.client.Basement;
import ru.rubicon.client.R;
import ru.rubicon.client.interfaces.IGitHubPresenter;
import ru.rubicon.client.interfaces.IGitHubView;

/**
 * Created by Витя on 31.10.2016.
 */

public class GitHubActivity extends AppCompatActivity implements IGitHubView {

    private Button btnGitGetUser, btnGitGetContributor;
    private TextView tvGit;
    private EditText etUserName, etGitRepo;
    private ProgressBar pbGit;

    @Inject
    IGitHubPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Basement.setGitHubComponent(this);
        IGitHubComponent component = Basement.getGitHubComponent();
        component.inject(this);
        initView();
    }

    private void initView() {
        setContentView(R.layout.git_activity);
        btnGitGetUser = (Button) findViewById(R.id.btnGitGetUser);
        btnGitGetContributor = (Button) findViewById(R.id.btnGitGetContributor);
        tvGit = (TextView) findViewById(R.id.tvGit);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etGitRepo = (EditText) findViewById(R.id.etGitRepo);
        pbGit = (ProgressBar) findViewById(R.id.pbGit);

        btnGitGetUser.setOnClickListener(new ButtonGitOnClickListener());
        btnGitGetContributor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.requestContributors(getOwnerName(), getRepoName());
            }
        });
    }


    private class ButtonGitOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            presenter.requestUser(etUserName.getText().toString());
        }
    }
    @Override
    public void setText(String string) {
        tvGit.setText(string);
    }

    @Override
    public String getOwnerName() {
        return etUserName.getText().toString();
    }

    @Override
    public String getRepoName() {
        return etGitRepo.getText().toString();
    }

    @Override
    public void showProgressBar() {
        pbGit.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbGit.setVisibility(ProgressBar.INVISIBLE);
    }

    public static void start(Context context){
        Intent intent = new Intent(context, GitHubActivity.class);
        context.startActivity(intent);
    }

}
