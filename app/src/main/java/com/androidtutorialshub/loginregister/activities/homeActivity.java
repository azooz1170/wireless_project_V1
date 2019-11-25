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
import java.util.Random;


public class homeActivity extends AppCompatActivity {
public double l1 =0 ;
    private Button send;
    String[] start = {"Choose a starting point", "Home", "Work"};
    String[] Dest = {"Choose a destination", "Home", "Work", "super market", "Restaurant", "coffee shop"};
    String[] time = {"00:00-05:00","06:00-09:00","10:00-12:00","13:00-16:00","17:00-20:00","21:00-23:00"};
    String recordStart = "";
    String recordDest = "";
    String x = "";
   // String date = new SimpleDateFormat(" HH:mm").format(Calendar.getInstance().getTime());
//    int dat = Integer.parseInt(date.replaceAll("[\\D]", ""));
    //double lat1 =startlat(recordStart) ;
int y ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, start);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Dest);
        final Random r = new Random();

        Spinner s = (Spinner) findViewById(R.id.start1);
        s.setAdapter(arrayAdapter);

        Spinner d = (Spinner) findViewById(R.id.Dest);
        d.setAdapter(arrayAdapter1);

        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homeActivity.this, homeActivity.class);
                startActivity(i);
            }
        });

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:

                        recordStart = "Choose a starting point";

                        break;

                    case 1:

                        recordStart = "Home";
                        y = 1;

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



        //final double lat1 = startlat(recordStart);
      //  final double lon1 = startlon("1");
//final double lat2 = Destlat(recordDest);
//final double lon2 = Destlon(recordDest);

//final int dis = r.nextInt(200) ;
//final double t = lon1;

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int dis = r.nextInt(200);

                randomnum(dis);

                final TextView s = (TextView) findViewById(R.id.textView6);
                s.setText("from: " + recordStart + "   " + "To: " + recordDest);
                final TextView d = (TextView) findViewById(R.id.textView7);
                d.setText("Distance: " + dis + "Use: " +  "\n" );


            }
        });





    }



//    public static double startlon(String home)
//    {
//       // double dat = Double.parseDouble(home.replaceAll("[\\D]", ""));
//        return l1=12334 ;
//    }

//    public static double distance(double start ,double dest )
//    {
//double result = dest-start ;
//return result ;
//
//    }
//
//public  double startlat(String start)
//{
//
//    lat1 = (start.equals("Home")) ? 0  : -1;
//
//
//
//return lat1;
//
//}

//
    public static double Destlat(String Dest) {
        double lat2 = 0;

        if (Dest.equals("Home")) {

            lat2 = 24.778326;

        } else if (Dest.equals("Work")) {

            lat2 = 24.812506;
        } else if (Dest.equals("supermarket")) {
            lat2 = 24.780491;

        } else if (Dest.equals("restaurant")) {
            lat2 = 24.809672;

        } else if (Dest.equals("coffee shop")) {
            lat2 = 24.734286;

        }
        return lat2;
    }
//
//    public static double Destlon(String Dest)
//    {
//        double lon2=0 ;
//
//        if (Dest.equals("Home")) {
//
//            lon2 = 46.776680;
//
//        } else if (Dest.equals("Work")) {
//
//            lon2 = 46.701314;
//        } else if (Dest.equals("supermarket")) {
//            lon2 = 46.773935;
//
//        } else if (Dest.equals("restaurant")) {
//            lon2 = 46.762948;
//
//        } else if (Dest.equals("coffee shop")) {
//            lon2 = 46.585076;
//
//        }
//
//        return lon2 ;
//    }
//

    void randomnum(int dis){
        if (dis<5)
        {
            x = "walk";
        }
        else if (dis<10 )
        {
            x = "cycle";
        }
        else if (dis<50 )
        {
            x = "Bus";
        }

        else if (dis<75)
        {
            x = "train";
        }

        else if (dis<100)
        {
            x = "car";
        }

        else
            x = "plane";
    }
}
