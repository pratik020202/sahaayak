package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    EditText weight,height,age;
    TextView result;
    RadioGroup radioButton;
    RadioButton male,female;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        result= findViewById(R.id.Answer);
        weight=findViewById(R.id.Weight);
        height=findViewById(R.id.Height);
        age= findViewById(R.id.Age);
        male= findViewById(R.id.rb1);
        female= findViewById(R.id.rb2);
        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double w,h,r,a;
                w=Double.parseDouble(weight.getText().toString());
                h=Double.parseDouble(height.getText().toString());
                a=Double.parseDouble(age.getText().toString());

                    switch (radioButton.getCheckedRadioButtonId()) {
                        case R.id.rb1:
                            r = 10 * w + 6.25 * h - 5 * a + 5;
                            result.setText(String.valueOf(r));
                            break;
                        case R.id.rb2:
                            r = 10 * w + 6.25 * h - 5 * a - 161;
                            result.setText(String.valueOf(r));
                            break;

                    }


            }
            });
        }
    }
