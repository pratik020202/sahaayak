package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }
    public void button1(View w){
        Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }
    public void button2(View w){
        Intent intent=new Intent(getApplicationContext(), MainActivity4.class);
        startActivity(intent);
    }
    public void button3(View v){
        Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(intent);
    }

}
