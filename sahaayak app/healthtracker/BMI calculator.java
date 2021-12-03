package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView tvresult;
    EditText etweight,etheight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etweight= findViewById(R.id.etweight);
        etheight= findViewById(R.id.etheight);
        tvresult= findViewById(R.id.textView5);
    }


    public void calculator(View v){
        double w,h,result;
        byte a;
        w=Double.parseDouble(etweight.getText().toString());
        h=Double.parseDouble(etheight.getText().toString());
        result=w*10000/h/h;
        tvresult.setText(String.valueOf(result));
        Toast.makeText(this,"BMI",Toast.LENGTH_SHORT).show();
        if(result<18.5){
            Toast.makeText(this,"YOU ARE UNDERWEIGHT",Toast.LENGTH_SHORT).show();
        }
        else if(result<24.9){
            Toast.makeText(this,"YOU ARE NORMAL",Toast.LENGTH_SHORT).show();
        }
        else if(result<29.9){
            Toast.makeText(this,"YOU ARE OVERWEIGHT",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"YOU ARE OBESE",Toast.LENGTH_SHORT).show();
        }
    }
}
