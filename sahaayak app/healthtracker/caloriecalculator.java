package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalorieCalculator extends AppCompatActivity {

    EditText weight,height,age;
    Button calculate;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);
        weight = findViewById(R.id.we);
        height = findViewById(R.id.he);
        age = findViewById(R.id.ag);
        result = findViewById(R.id.finalanswer);
        calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity();
            }
        });


    }
    public void openNewActivity(){
        double Weight, Age, Height, ResultM, ResultF;
        Weight = Double.parseDouble(weight.getText().toString());
        Age = Double.parseDouble(age.getText().toString());
        Height = Double.parseDouble(age.getText().toString());
        ResultM = (Weight * 100) * (Height * 6.25) * (Age * 5) / 5;
        result.setText(String.valueOf(ResultM));

    }
}
