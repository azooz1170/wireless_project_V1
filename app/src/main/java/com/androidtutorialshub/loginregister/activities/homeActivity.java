package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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

    double lat1 = 0,lon1 = 0;


    double lat2= 0,lon2 = 0;





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

        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homeActivity.this,homeActivity.class);
                startActivity(i);
            }
        });

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)

                {

                    case 0:

                        recordStart = "Choose a starting point";

                        break;

                    case 1:

                        recordStart = "Home";

                        break;

                    case 2:

                        recordStart = "Work";

                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:

                        recordDest = "Choose a destination";

                        break;

                    case 1:

                        recordDest = "Home";

                        break;

                    case 2:

                        recordDest = "Work";

                        break;
                    case 3:

                        recordDest = "supermarket";

                        break;

                    case 4:

                        recordDest = "restaurant";

                        break;

                    case 5:

                        recordDest = "coffee shop";

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (recordStart.equals("Home"))
        {
            lat1 = 2.778122;
            lon1 = 24.818663;
        }
        else if (recordStart.equals("Work"))
        {
            lat1 = 2.778122;
            lon1 = 24.818663;
        }






        if (recordDest.equals("Home"))
        {
            lat2 = 2.778122;
            lon2 = 24.818663;

        }
        else if (recordDest.equals("Work"))
        {
            lat2 = 2.778122;
            lon2 = 24.818663;

        }
        else if (recordDest.equals("supermarket"))
        {
            lat2 = 2.778122;
            lon2 = 24.818663;

        }
        else if (recordDest.equals("restaurant"))
        {
            lat2 = 98.778122;
            lon2 = 89.818663;

        }
        else if (recordDest.equals("coffee shop"))
        {
            lat2 = 2.778122;
            lon2 = 24.818663;

        }



       final  double dis = distance(lat1, lat2, lon1, lon2);

        if (dis<5)
        {
           when="walk";
        }
        else if (dis>5&&dis<=100)
        {
            when="car";
        }
        else
            when="airplane";





        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView s = (TextView) findViewById(R.id.textView6);
                s.setText(recordStart+dat);
                final TextView d = (TextView) findViewById(R.id.textView7);
                d.setText(recordDest+dis);
            }
        });

    }
    public static double distance(double lat1, double lat2, double lon1, double lon2)
    {

        double earthRadius = 6371.0;
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lon2-lon1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c/100;
        // calculate the result
        return Math.round( dist * 100.0 ) / 100.0 ;
    }


}
