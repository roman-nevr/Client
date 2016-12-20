package ru.rubicon.client.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import ru.rubicon.client.Basement;
import ru.rubicon.client.R;
import ru.yoursolution.servermodule.okhttp.OkHttpTest;

import static ru.rubicon.client.Basement.log;

/**
 * Created by Admin on 14.12.2016.
 */

public class ServerConnectionTest extends AppCompatActivity {
    EditText etField;
    Button btnButton, button;
    TextView tvText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_activity_layout);

        etField = (EditText) findViewById(R.id.etName);
        btnButton = (Button) findViewById(R.id.btnAdd);
        tvText = (TextView) findViewById(R.id.recyclerView);
        tvText.setMovementMethod(new ScrollingMovementMethod());
        btnButton.setOnClickListener(v -> onClick(v));
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(o -> onButton(o));
        button.setText("Moon");
        btnButton.setText("GitHub");
    }

    private void onButton(View o) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpTest test = new OkHttpTest();
                try {
                    log.clear();
                    String res = test.testAuthMoon();
                    setText(res);
                } catch (IOException e) {
                    setText(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void onClick(View v) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpTest test = new OkHttpTest();
                try {
                    log.clear();
                    String res = test.testAuthGitHub();
                    setText(res);
                } catch (IOException e) {
                    setText(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


    private void setText(String arg){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvText.setText(arg);
            }
        });
    }


}
