package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ListContactShow extends AppCompatActivity {
    TextView fName,lName,email,tel;
    ImageView img;
    Button btnR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact_show);
        ContactClass u=(ContactClass) getIntent().getExtras().get("UserObj");

        fName=findViewById(R.id.firstNameListContact);
        lName=findViewById(R.id.lastnameListContact);
        email=findViewById(R.id.EmailListContact);
        tel=findViewById(R.id.telListContact);
        img=findViewById(R.id.imgListContact);
        btnR=findViewById(R.id.btnRetourListContact);
        fName.setText(u.getNom());
        lName.setText(u.getPrenom());
        email.setText(u.getEmail());
        tel.setText(u.getTel());
        img.setImageResource(u.getImage());
        ///

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}