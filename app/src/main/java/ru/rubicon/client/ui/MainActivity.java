package ru.rubicon.client.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import ru.rubicon.client.Basement;
import ru.rubicon.client.R;
import ru.rubicon.client.di.AgeModule;
import ru.rubicon.client.di.Components.IPresenterComponent;
import ru.rubicon.client.model.Age;
import ru.rubicon.client.model.User;
import ru.rubicon.client.interfaces.IPresenter;
import ru.rubicon.client.interfaces.IShowUser;

/**
 * Created by Витя on 24.10.2016.
 */

public class MainActivity extends AppCompatActivity implements IShowUser {

    private TextView tvText1, tvText2;
    private Button btnNextUser, btnNextActivity;

    @Inject
    IPresenter presenter;

    User user;
    Age age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        Basement.setPresenterComponent(this);
        IPresenterComponent component = Basement.getComponent();
        component.inject(this);
    }

    @Override
    public void showUser(User user) {
        tvText1.setText("Name : "+user.getName());
        tvText2.setText("Age : "+user.getAge());
    }

    private void initView(){
        setContentView(R.layout.main);
        tvText1 = (TextView) findViewById(R.id.textView);
        tvText2 = (TextView) findViewById(R.id.textView2);
        btnNextUser = (Button) findViewById(R.id.btnNextUser);
        btnNextUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressButtonNextUser();
            }
        });
        btnNextActivity = (Button) findViewById(R.id.btnNextActivity);
        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressButtonNextActivity(MainActivity.this);
            }
        });
    }
}
