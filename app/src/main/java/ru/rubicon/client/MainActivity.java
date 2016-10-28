package ru.rubicon.client;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import ru.rubicon.client.di.IPresenterComponent;
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

        Basement.setComponent(this);
        IPresenterComponent component = Basement.getComponent();
        component.inject(this);
        //presenter = Basement.getComponent().getPresenter();
    }

    @Override
    public void show(User user) {
        tvText1.setText("Name : "+user.getName());
        tvText2.setText("Age : "+user.getAge());
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
