package com.example.tripapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends Activity {
    private ProgressBar progressBar;
    int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        Thread thred = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }});
        thred.start();
    }
    public void doWork() {
        for (progress=10;progress<100;progress=progress+20){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }} }
    public void startApp(){
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }}