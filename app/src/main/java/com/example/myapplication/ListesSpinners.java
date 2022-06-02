package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ListesSpinners extends AppCompatActivity {
    ArrayList<Countries> countrie=new ArrayList<Countries>();
    Spinner s;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listes_spinners);
        s=(Spinner) findViewById(R.id.sp1);
        img=findViewById(R.id.imgForCountry);
        //String[] days = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        countrie.add(new Countries("India",R.drawable.image1));
        countrie.add(new Countries("Morroco",R.drawable.image2));
        countrie.add(new Countries("Russia",R.drawable.image3));
        ArrayList<String> nomPays=new ArrayList<>();
        for(Countries c : countrie){
            nomPays.add(c.getName());
        }
        ArrayAdapter ad = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,nomPays);
        s.setAdapter(ad);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Countries v = adapterView.getItemAtPosition(i);
                Countries v = countrie.get(i);


                // Toast.makeText(getApplicationContext(),v,Toast.LENGTH_LONG).show();

                img.setImageResource(v.getPicture());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}