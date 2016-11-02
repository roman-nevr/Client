package ru.rubicon.client.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import ru.rubicon.client.Basement;
import ru.rubicon.client.R;
import ru.rubicon.client.di.Components.IPresenterComponent;
import ru.rubicon.client.entities.User;
import ru.rubicon.client.interfaces.IPresenter;
import ru.rubicon.client.interfaces.IShowUser;

/**
 * Created by Витя on 24.10.2016.
 */

public class MainActivity extends AppCompatActivity implements IShowUser {

    private TextView tvText1, tvText2;
    private Button btnNext;

    @Inject
    IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        Basement.setPresenterComponent(this);
        IPresenterComponent component = Basement.getComponent();
        component.inject(this);
    }

    @Override
    public void show(User user) {
        tvText1.setText("Name : "+user.getName());
        tvText2.setText("Age : "+user.getAge());
        Intent intent = new Intent(this, GitHubActivity.class);
        startActivity(intent);
    }

    private void initView(){
        setContentView(R.layout.main);
        tvText1 = (TextView) findViewById(R.id.textView);
        tvText2 = (TextView) findViewById(R.id.textView2);
        btnNext = (Button) findViewById(R.id.button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressButtonNext();
            }
        });
    }
}
