package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class SqliteExercice extends AppCompatActivity {
    Spinner s;
    Button btn,btnShow;
    MyDbContact db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_exercice);
        s=findViewById(R.id.spSqlLite);
        btn=findViewById(R.id.btnSumbetSql);
        btnShow=findViewById(R.id.btnAfficheSql);
        db=new MyDbContact(this);
        //ArrayList<ContactClass> listContact=new ArrayList<>();
        //listContact.add(new ContactClass(R.drawable.image1,"Ahmed","Ahmedi","Ahmed@gmail.com","062918374"));
        //listContact.add(new ContactClass(R.drawable.image2,"Anas","Ahmedi","Ahmed@gmail.com","062918374"));
        //listContact.add(new ContactClass(R.drawable.image3,"Hatim","Ahmedi","Ahmed@gmail.com","062918374"));
        //listContact.add(new ContactClass(R.drawable.image4,"Zakaria","Ahmedi","Ahmed@gmail.com","062918374"));
        //listContact.add(new ContactClass(R.drawable.image5,"Youssef","Ahmedi","Ahmed@gmail.com","062918374"));
        //listContact.add(new ContactClass(R.drawable.image6,"Adam","Ahmedi","Ahmed@gmail.com","062918374"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MyDbContact.insertContact(db.getWritableDatabase(),new ContactClass(R.drawable.image1,"Ahmed","Ahmedi","Ahmed@gmail.com","062918374"));
                MyDbContact.insertContact(db.getWritableDatabase(),new ContactClass(R.drawable.image2,"Anas","Ahmedi","Ahmed@gmail.com","062918374"));
                MyDbContact.insertContact(db.getWritableDatabase(),new ContactClass(R.drawable.image3,"Hatim","Ahmedi","Ahmed@gmail.com","062918374"));
            }
        });
        ArrayList<ContactClass> sts = MyDbContact.getAllContacs(db.getReadableDatabase());

        ArrayList<String> noms=new ArrayList<>();
        for(ContactClass s:sts) {
            noms.add(s.getNom()) ;
        }
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,noms);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setAdapter(ad);
            }
        });
    }
}