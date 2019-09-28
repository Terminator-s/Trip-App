package com.example.tripapp;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection Instance;
    private static Connection connection;

    // This works according to singleton pattern
    @SuppressLint("NewApi")
    public static Connection CONN() {
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
             StrictMode.setThreadPolicy(policy);

            try {
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://34.66.239.252:3306/bustravel";
                String username = "root";
                String password = "terminators123";
                if (connection == null || connection.isClosed()) {
                    Class.forName(driver).newInstance();  //load driver
                    connection = DriverManager.getConnection(url, username, password);
                    //creating connection

                }
            } catch (SQLException se) {
                Log.e("ERRO", se.getMessage());
            } catch (ClassNotFoundException e) {
                Log.e("ERRO", e.getMessage());
            } catch (Exception e) {
                Log.e("ERRO", e.getMessage());
            }
            return connection;
        }
    }
}

