package com.example.sahaayak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity4 extends AppCompatActivity {

    public ListView listView;
    String[] time ={"00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00",
    "10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00",
    "22:00","23:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity4.this ,
                android.R.layout.simple_dropdown_item_1line,time);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // openActivity5();
                Toast.makeText(MainActivity4.this, "Clicked " + time[i] , Toast.LENGTH_SHORT).show();
                String timeEdit = Arrays.toString(new String[]{time[i]});
                Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                intent.putExtra("keyname",timeEdit);

                startActivity(intent);
            }
        });


    }
