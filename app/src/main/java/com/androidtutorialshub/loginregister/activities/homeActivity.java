package com.androidtutorialshub.loginregister.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.androidtutorialshub.loginregister.R;


import java.text.SimpleDateFormat;

import java.util.Calendar;




public class homeActivity extends AppCompatActivity {
    private Button send;
    String[] start = {"Choose a starting point", "Home", "Work"};
    String[] Dest = {"Choose a destination", "Home", "Work", "super market", "Restaurant", "coffee shop"};
    String[] time = {"00:00-05:00","06:00-09:00","10:00-12:00","13:00-16:00","17:00-20:00","21:00-23:00"};
    String recordStart = "";
    String recordDest = "";
    String when = "";
    String date = new SimpleDateFormat(" HH:mm").format(Calendar.getInstance().getTime());
    int dat = Integer.parseInt(date.replaceAll("[\\D]", ""));

    double lat1 = 24.778122; // in db
    double lat2 = 46.776445;
    double lon1 = 24.818663;
    double lon2 = 64.712312;

   // double dis = distance(lat1, lat2, lon1, lon2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, start);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Dest);

        Spinner s = (Spinner) findViewById(R.id.start1);
        s.setAdapter(arrayAdapter);

        Spinner d = (Spinner) findViewById(R.id.Dest);
        d.setAdapter(arrayAdapter1);


    }
}
