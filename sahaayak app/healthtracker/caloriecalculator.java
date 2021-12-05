package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    EditText weight,height,age;
    RadioGroup radioGroup;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        weight=findViewById(R.id.we);
        height=findViewById(R.id.he);
        age=findViewById(R.id.ag);
        result=findViewById(R.id.finalanswer);
        radioGroup= findViewById(R.id.radioGroup2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                double Weight,Age,Height,Result;
                Weight=Double.parseDouble(weight.getText().toString());
                Age=Double.parseDouble(age.getText().toString());
                Height=Double.parseDouble(age.getText().toString());
                switch (checkedId){
                    case R.id.male:{
                        Result= (Weight*100)*(Height*6.25)*(Age*5)/5 ;
                        result.setText(String.valueOf(Result));
                    }
                    case R.id.female:{
                        Result= (Weight*100)/(Height*6.25)/(Age*5)*161 ;
                        result.setText(String.valueOf(Result));
                    }
                }
            }
        });

    }
}
