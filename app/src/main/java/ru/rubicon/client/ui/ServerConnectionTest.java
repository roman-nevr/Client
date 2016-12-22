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

import ru.rubicon.client.R;
import ru.yoursolution.servermodule.okhttp.OkHttpTest;
import ru.yoursolution.servermodule.okhttp.OkHttpTestMoon;

/**
 * Created by Admin on 14.12.2016.
 */

public class ServerConnectionTest extends AppCompatActivity {
    EditText etField;
    Button btnLeft, btnRight, btnCentral;
    TextView tvText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_activity_layout);

        etField = (EditText) findViewById(R.id.etName);
        btnLeft = (Button) findViewById(R.id.btnAdd);
        tvText = (TextView) findViewById(R.id.recyclerView);
        tvText.setMovementMethod(new ScrollingMovementMethod());
        btnLeft.setOnClickListener(v -> onClick(v));
        btnCentral = (Button) findViewById(R.id.btnCentral);
        btnCentral.setOnClickListener(o -> onCentralButton(o));
        btnRight = (Button) findViewById(R.id.btnRight);
        btnRight.setOnClickListener(o -> onRightButton(o));
        btnRight.setText("Moon");
        btnLeft.setText("GitHub");
        btnCentral.setText("test");

    }

    private void onCentralButton(View o) {
        Thread thread = new TestTread() {
            @Override public String operation() throws IOException {
                OkHttpTest test = new OkHttpTest();
                return test.testAuthMoon();
            }
        };
        thread.start();
    }

    private void onRightButton(View o) {
        Thread thread = new TestTread() {
            @Override public String operation() throws IOException {
                OkHttpTestMoon test = new OkHttpTestMoon();
                return test.testAuthMoon();
            }
        };
        thread.start();
    }

    private void onClick(View v) {
        Thread thread = new TestTread() {
            @Override public String operation() throws IOException {
                OkHttpTest test = new OkHttpTest();
                return test.testAuthGitHub();
            }
        };
        thread.start();
    }

    private abstract class TestTread extends Thread{
        public TestTread() {
            super();
        }
        @Override public void run() {
            try {
                String res = operation();
                setText(res);
            } catch (Exception e) {
                setText(e.getClass() + " : " + e.getMessage());
                e.printStackTrace();
            }
        }

        public abstract String operation() throws IOException;
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
