package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Exercice1RadioButton extends AppCompatActivity {
    RadioGroup rdg,grpImage;
    RadioButton img1,img2,img3;
    Button btn1,btn2,btn3,btnClear,btnAffiche,btnDisplay;
    CheckBox iphon,anroid,win;
    ImageView mainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice1_radio_button);
        rdg=findViewById(R.id.rdGrop);
        btn1=findViewById(R.id.ch1);
        btn2=findViewById(R.id.ch2);
        btn3=findViewById(R.id.ch3);
        btnClear=findViewById(R.id.btnClear);
        btnAffiche=findViewById(R.id.btnAf);
        ////
        btnDisplay=findViewById(R.id.btnDisplay);
        iphon=findViewById(R.id.Iphone);
        anroid=findViewById(R.id.android);
        win=findViewById(R.id.windowsPhone);
        /////
        grpImage=findViewById(R.id.grpImage);
        mainImage=findViewById(R.id.mainImage);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdg.check(R.id.rd1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdg.check(R.id.rd2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdg.check(R.id.rd3);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdg.clearCheck();
            }
        });
        btnAffiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdg.getCheckedRadioButtonId()==R.id.rd1){
                    Toast.makeText(Exercice1RadioButton.this, "radio 1 ", Toast.LENGTH_SHORT).show();
                }
                if(rdg.getCheckedRadioButtonId()==R.id.rd2){
                    Toast.makeText(Exercice1RadioButton.this, "radio 2 ", Toast.LENGTH_SHORT).show();
                }
                if(rdg.getCheckedRadioButtonId()==R.id.rd3){
                    Toast.makeText(Exercice1RadioButton.this, "radio 3 ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result=iphon.getText().toString()+" : "+iphon.isChecked()+
                        "\n"+anroid.getText().toString()+" : "+anroid.isChecked()+
                        "\n"+win.getText().toString()+" : "+win.isChecked();
                Toast.makeText(Exercice1RadioButton.this, ""+result, Toast.LENGTH_SHORT).show();
            }
        });
        grpImage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId()==R.id.img1){
                    mainImage.setImageResource(R.drawable.s1);
                }
                if(radioGroup.getCheckedRadioButtonId()==R.id.img2){
                    mainImage.setImageResource(R.drawable.s2);
                }
                if(radioGroup.getCheckedRadioButtonId()==R.id.img3){
                    mainImage.setImageResource(R.drawable.s3);
                }
            }
        });

    }
}