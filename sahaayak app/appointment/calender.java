package com.example.sahaayak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.Properties;

public class MainActivity2 extends AppCompatActivity {
    public CalendarView calendarView;
    public Button newAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        calendarView = (CalendarView) findViewById(R.id.calender);

        HashMap<Object, Properties> descHashMap =new HashMap<>();

        Properties defaultProperty = new Properties();

        newAppointment =(Button) findViewById(R.id.newEvent);
        newAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }

        });


    }
    public void openActivity4(){
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);

        }



}
