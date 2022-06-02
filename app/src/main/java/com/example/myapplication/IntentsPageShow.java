package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class IntentsPageShow extends AppCompatActivity {
    TextView fName,lName,BirthDate;
    ImageView img;
    Button btnR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_page_show);


        UsersForIntents u=(UsersForIntents) getIntent().getExtras().get("UserObj");

        fName=findViewById(R.id.firstNameI);
        lName=findViewById(R.id.lastnameI);
        BirthDate=findViewById(R.id.birthdateI);
        img=findViewById(R.id.imgI);
        btnR=findViewById(R.id.btnRetourI);
        fName.setText(u.getFirstName());
        lName.setText(u.getLastName());
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");

        BirthDate.setText(f.format(u.getBirthDate()).toString());
        if(u.getImage()==1){
            img.setImageResource(R.drawable.image1);
        }
        if(u.getImage()==2){
            img.setImageResource(R.drawable.image2);
        }
        if(u.getImage()==3){
            img.setImageResource(R.drawable.image3);
        }
        if(u.getImage()==4){
            img.setImageResource(R.drawable.image4);
        }
        if(u.getImage()==5){
            img.setImageResource(R.drawable.image5);
        }
        if(u.getImage()==6){
            img.setImageResource(R.drawable.image6);
        }

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}