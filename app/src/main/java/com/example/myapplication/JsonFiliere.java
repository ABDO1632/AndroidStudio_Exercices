package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonFiliere extends AppCompatActivity {
    EditText tC,tD,tNv,tNb;
    Button btn,btn2;
    MyDbFiliere db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_filiere);
        tC=findViewById(R.id.jsonFCode);
        tD=findViewById(R.id.jsonFDesc);
        tNv=findViewById(R.id.jsonFNiveau);
        tNb=findViewById(R.id.jsonFNbModule);
        btn=findViewById(R.id.jsonFBtn);
        btn2=findViewById(R.id.jsonFBtn2);

        db=new MyDbFiliere(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filiere pr1=new Filiere(tC.getText().toString(),tD.getText().toString(),tNv.getText().toString(),Integer.valueOf(tNb.getText().toString()));
                long r=MyDbFiliere.insertFiliere(db.getWritableDatabase(),pr1);

                if(r!=-1){
                    Toast.makeText(getApplicationContext(),"Insertion Reussie",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Insertion Echoue",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json=lstJson(R.raw.filier);
                try {
                    JSONObject arr=new JSONObject(json);
                    Filiere pr1=new Filiere(arr.getString("code"),arr.getString("description"),arr.getString("niveau"),Integer.valueOf(arr.getString("nbModule")));
                    long r=MyDbFiliere.insertFiliere(db.getWritableDatabase(),pr1);

                    if(r!=-1)
                    {
                        Toast.makeText(getApplicationContext(),"Insertion Reussie",Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Insertion Echoue",Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });



    }

    public String lstJson(int resId){
        int taille=0;
        String res="";
        try  {
            InputStream input = getResources().openRawResource(resId);
            byte[]data=new byte[input.available()];
            input.read(data);
            input.close();
            res=new String(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }
}