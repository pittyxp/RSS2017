package com.edin.aron.rss2017;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    private int timeout = 3000;

    private boolean handlerStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (savedInstanceState != null) {
            handlerStarted = savedInstanceState.getBoolean("handleStarted");
        }

        if (!handlerStarted) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i= new Intent(splash.this, LoginActivity.class);
                    startActivity(i);

                    finish();
                }
            }, timeout);
            handlerStarted = true;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putBoolean("handlerStarted", handlerStarted);
        super.onSaveInstanceState(outState);
    }
}
