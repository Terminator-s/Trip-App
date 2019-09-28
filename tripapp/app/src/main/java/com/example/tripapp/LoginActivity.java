package com.example.tripapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}


//    private class LoginTask extends AsyncTask<String,String,String> {
//        String token = tokenId.getText().toString();
//        String password = tokenId.getText().toString();
//        String msg;
//        @Override
//        protected String doInBackground(String... string) {
//
//
//            try {
//                Connection con =DbConnection.CONN();
//
//                Statement stmt = con.createStatement();
//                String query = "select id,password from user";
//                ResultSet result = stmt.executeQuery(query);
//
//                while(result.next()){
//                    if(token == result.getString("id") && password == result.getString("password")){
//                        msg = "success";
//                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//                        startActivity(intent);
//
//                    }
//                    else{
//                       msg = "not success";
//
//                    }
//                }
//               con.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return msg;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            msgtext.setText(msg);
//        }

