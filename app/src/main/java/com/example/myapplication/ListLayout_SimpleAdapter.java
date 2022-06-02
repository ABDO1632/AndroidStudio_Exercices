package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

public class ListLayout_SimpleAdapter extends AppCompatActivity {
    ArrayList<Countries> countrie=new ArrayList<Countries>();
    ListView s;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout_simple_adapter);
        s=(ListView) findViewById(R.id.list1);
        img=findViewById(R.id.imglist1);
        //String[] days = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        countrie.add(new Countries("India",R.drawable.image1));
        countrie.add(new Countries("Morroco",R.drawable.image2));
        countrie.add(new Countries("Russia",R.drawable.image3));
        ArrayList<HashMap<String,Object>> lstItems=new ArrayList<>();
        for(Countries c : countrie){
            HashMap<String,Object> it=new HashMap<String,Object>();
            it.put("imgP",c.getPicture());
            it.put("txtP",c.getName());
            lstItems.add(it);
            //nomPays.add(c.getName());
        }
        String[] from={"imgP","txtP"};
        int[] to={R.id.imgLineStructure,R.id.textLineStructure};
        SimpleAdapter ad = new SimpleAdapter(this,lstItems,R.layout.line_structure,from,to);
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