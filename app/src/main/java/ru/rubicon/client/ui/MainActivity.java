package ru.rubicon.client.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import ru.rubicon.client.Basement;
import ru.rubicon.client.R;
import ru.rubicon.client.di.Components.IPresenterComponent;
import ru.rubicon.client.model.Age;
import ru.rubicon.client.model.User;
import ru.rubicon.client.interfaces.IPresenter;
import ru.rubicon.client.interfaces.IShowUser;

/**
 * Created by Витя on 24.10.2016.
 */

public class MainActivity extends AppCompatActivity{

    private Button btnMoon, btnGit, btn1c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        buttonSettings(btnMoon, R.id.btn_moon, new OnMoonClick());
        buttonSettings(btnGit, R.id.btn_github, new OnGitHubClick());
        buttonSettings(btn1c, R.id.btn_odinesnik, new On1cClick());
    }


    private void buttonSettings(Button btn, @IdRes int id, View.OnClickListener listener){
        btn = (Button) findViewById(id);
        btn.setOnClickListener(listener);
    }

    private class OnMoonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MetadataUi.class);
            startActivity(intent);
        }
    }

    private class OnGitHubClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, GitHubActivity.class);
            startActivity(intent);
        }
    }

    private class On1cClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Odinesnik.class);
            startActivity(intent);
        }
    }
}
