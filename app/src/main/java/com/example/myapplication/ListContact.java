package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListContact extends AppCompatActivity {




    ArrayList<ContactClass> listContact=new ArrayList<>();
    ListView listV;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        listV=(ListView) findViewById(R.id.listConactLV);
        img=findViewById(R.id.listConactImg);
        listContact.add(new ContactClass(R.drawable.image1,"Ahmed","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image2,"Anas","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image3,"Hatim","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image4,"Zakaria","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image5,"Youssef","Ahmedi","Ahmed@gmail.com","062918374"));
        listContact.add(new ContactClass(R.drawable.image6,"Adam","Ahmedi","Ahmed@gmail.com","062918374"));
        ArrayList<HashMap<String,Object>> lstItems=new ArrayList<>();
        for(ContactClass c : listContact){
            HashMap<String,Object> it=new HashMap<String,Object>();
            it.put("imgP",c.getImage());
            it.put("txtP",c.getNom()+" "+c.getPrenom());
            lstItems.add(it);
            //nomPays.add(c.getName());
        }
        String[] from={"imgP","txtP"};
        int[] to={R.id.imgLineStructure,R.id.textLineStructure};
        SimpleAdapter ad = new SimpleAdapter(this,lstItems,R.layout.line_structure,from,to);
        listV.setAdapter(ad);
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ContactClass v = listContact.get(i);
                Toast.makeText(getApplicationContext(), "pos: /"+i, Toast.LENGTH_SHORT).show();
                Intent in=new Intent(ListContact.this,ListContactShow.class);
                in.putExtra("UserObj",v);
                startActivity(in);
            }
        });
    }
}