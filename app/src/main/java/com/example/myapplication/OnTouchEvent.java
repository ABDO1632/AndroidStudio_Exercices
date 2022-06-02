package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class OnTouchEvent extends AppCompatActivity {
    EditText txtNom,txtPrenom;
    ImageView img;
    Button btnP,btnN;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch_event);
        txtNom=findViewById(R.id.nomTouchEvent);
        txtPrenom=findViewById(R.id.prenomTouchEvent);
        img=findViewById(R.id.imgTouchEvent);
        btnP=findViewById(R.id.btnPreviosTouchEvent);
        btnN=findViewById(R.id.btnNextTouchEvent);

        ArrayList<ContactClass> listContact=new ArrayList<>();
        listContact.add(new ContactClass(R.drawable.image1,"Ahmed","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image2,"Anas","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image3,"Hatim","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image4,"Zakaria","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image5,"Youssef","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image6,"Adam","Ahmedi","Ahmed@gmail.com","062918374"));
        ///
        ContactClass c=listContact.get(i);
        txtNom.setText(c.getNom());
        txtPrenom.setText(c.getPrenom());
        img.setImageResource(c.getImage());
        ///
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i==listContact.size()){
                    i=0;
                }

                Toast.makeText(OnTouchEvent.this, "f:"+String.valueOf(i)+" : "+listContact.size(), Toast.LENGTH_SHORT).show();
                ContactClass c=listContact.get(i);
                txtNom.setText(c.getNom());
                txtPrenom.setText(c.getPrenom());
                img.setImageResource(c.getImage());
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                if(i==0){
                    i=listContact.size();
                }

                Toast.makeText(OnTouchEvent.this, "f:"+String.valueOf(i), Toast.LENGTH_SHORT).show();

                ContactClass c=listContact.get(i);
                txtNom.setText(c.getNom());
                txtPrenom.setText(c.getPrenom());
                img.setImageResource(c.getImage());
            }
        });
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float dxP=0f;
                float dxN=0f;
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    dxP=motionEvent.getX();
                }
                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    dxN=motionEvent.getX();
                    if(dxP>dxN){
                        AlphaAnimation an = new AlphaAnimation(1f,0f);
                        an.setDuration(300);
                        img.startAnimation(an);
                        //Toast.makeText(OnTouchEvent.this, "dxP:"+dxP+"dxN"+dxN, Toast.LENGTH_SHORT).show();
                        TranslateAnimation a = new TranslateAnimation(0f,-2000f,0,0);
                        a.setDuration(100);


                        img.startAnimation(a);
                        i--;
                        ContactClass c=listContact.get(i);
                        txtNom.setText(c.getNom());
                        txtPrenom.setText(c.getPrenom());
                        img.setImageResource(c.getImage());
                    }
                    else {
                        TranslateAnimation a = new TranslateAnimation(0f,2000f,0,0);
                        a.setDuration(100);
                        img.startAnimation(a);
                        i++;
                        ContactClass c=listContact.get(i);
                        txtNom.setText(c.getNom());
                        txtPrenom.setText(c.getPrenom());


                        img.setImageResource(c.getImage());
                    }
                }
                //Important to return true!!!!
                return true;
            }
        });
    }
}