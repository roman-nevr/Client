package ru.rubicon.client.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import ru.rubicon.client.di.Components.IGitHubComponent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    Button btnGit;
    TextView tvGit;
    EditText etUserName;

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
        btnGit = (Button) findViewById(R.id.btnGit);
        tvGit = (TextView) findViewById(R.id.tvGit);
        etUserName = (EditText) findViewById(R.id.etUserName);

        btnGit.setOnClickListener(new ButtonGitOnClickListener());
    }

    @Override
    public void setText(String string) {
        tvGit.setText(string);
    }

    @Override
    public String getText() {
        return etUserName.getText().toString();
    }

    private class ButtonGitOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            presenter.getResponse(etUserName.getText().toString());
        }

    }
}
