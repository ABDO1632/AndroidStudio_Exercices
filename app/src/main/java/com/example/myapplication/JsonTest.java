package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonTest extends AppCompatActivity {
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_test);
        lst=findViewById(R.id.lstJson);
        String json=lstJson(R.raw.filier);
        try {
            JSONArray arr=new JSONArray(json);
            ArrayList<String> fils=new ArrayList<>();
            for (int i=0;i<arr.length();i++)
            {
                JSONObject obj=arr.getJSONObject(i);
                fils.add(obj.getString("code"));
            }
            ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,fils);
            lst.setAdapter(ad);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String lstJson(int resId){
        int taille=0;
        String res="";
        try (InputStream input = getResources().openRawResource(resId)) {
            taille = input.available();
            byte[]data=new byte[taille];
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