package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exam2019 extends AppCompatActivity {
    Button btnC;
    EditText nbD,nbP,res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2019);
        nbP=findViewById(R.id.nbPoids);
        nbD=findViewById(R.id.nbDistance);
        res=findViewById(R.id.Res);
        btnC=findViewById(R.id.btnC);

    }
    public void onClickHandler(View view){
        if(Double.parseDouble(nbD.getText().toString())<=100){
            if(Double.parseDouble(nbP.getText().toString())<=15){
                double i=Double.parseDouble(nbP.getText().toString())*5;
                res.setText(String.valueOf(i));
            }
            if(Double.parseDouble(nbP.getText().toString())>=15 && Double.parseDouble(nbP.getText().toString())<=30){
                double i=Double.parseDouble(nbP.getText().toString())*7.50;
                res.setText(String.valueOf(i));
            }
            if(Double.parseDouble(nbP.getText().toString())>30){
                double i=Double.parseDouble(nbP.getText().toString())*10;
                res.setText(String.valueOf(i));
            }
        }
        if(Double.parseDouble(nbD.getText().toString())>100){
            if(Double.parseDouble(nbP.getText().toString())<=15){
                double i=Double.parseDouble(nbP.getText().toString())*8;
                res.setText(String.valueOf(i));
            }
            if(Double.parseDouble(nbP.getText().toString())>=15 && Double.parseDouble(nbP.getText().toString())<=30){
                double i=Double.parseDouble(nbP.getText().toString())*9;
                res.setText(String.valueOf(i));
            }
            if(Double.parseDouble(nbP.getText().toString())>30){
                double i=Double.parseDouble(nbP.getText().toString())*11;
                res.setText(String.valueOf(i));
            }
        }
        res.setText(res.getText()+" dh");
    }
}