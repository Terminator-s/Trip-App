package com.example.tripapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //db connections
    private static final String url = "jdbc:mysql://34.66.239.252:3306/bustravel";
    private static final String user = "root";
    private static final String pass = "terminators123";

    ListView historyList;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //toolbar and navigator start----------------------------------------------------------------
        {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

        }
        //toolbar and navigator end----------------------------------------------------------------

        dbHistory db = new dbHistory();
        db.execute("");


        historyList = (ListView) findViewById(R.id.historyList);
//        final ArrayList<String> scheduleList = new ArrayList<>();
//        scheduleList.add("his1");
//        scheduleList.add("his2");
//        scheduleList.add("his3");
//        scheduleList.add("his4");

//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, scheduleList);
//
//        historyList.setAdapter(adapter);


//        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(HistoryActivity.this,"clicked"+position+scheduleList.get(position).toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    //toolbar and navigator function start----------------------------------------------------------------
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(this,MainActivity.class));
        } else if (id == R.id.nav_schedule) {
            startActivity(new Intent(this,ScheduleActivity.class));
        } else if (id == R.id.nav_history) {
            startActivity(new Intent(this,HistoryActivity.class));
        } else if (id == R.id.nav_balance) {
            startActivity(new Intent(this,BalanceActivity.class));
        } else if (id == R.id.nav_profile) {
            Intent intent=new Intent(this,UserProfileActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_payment) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class dbHistory extends AsyncTask<String, Void, String> {
        String res = "";

        @Override
        protected String doInBackground(String... params) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = DriverManager.getConnection(url, user, pass);
                String result = " ";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from trip ");
                ResultSetMetaData rsmd = rs.getMetaData();

                List<Map<String, String>> data = new ArrayList<Map<String, String>>();

                while (rs.next()) {
                    Map<String, String> datanum = new HashMap<String, String>();
                    datanum.put("A", rs.getString(1).toString());
                    data.add(datanum);
                }

                String[] fromwhere = {"A"};
                int[] viewswhere = {R.id.detail};
                adapter = new SimpleAdapter(HistoryActivity.this, data,
                        R.layout.listtemplate, fromwhere, viewswhere);

                while (rs.next()) {
                    result += rs.getString(1).toString() + "\n";
                }
                res = result;
            } catch (Exception e) {
                e.printStackTrace();
                res = e.toString();
            }
            return res;
        }


        @Override
        protected void onPostExecute(String result) {
            historyList.setAdapter(adapter);
        }
    }
}