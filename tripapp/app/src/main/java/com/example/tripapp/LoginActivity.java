package com.example.tripapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {
     Button signinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signinbtn = findViewById(R.id.signinbtn);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
