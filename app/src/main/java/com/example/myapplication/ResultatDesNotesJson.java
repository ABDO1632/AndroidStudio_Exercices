package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ResultatDesNotesJson extends AppCompatActivity {
    EditText tId,tNom,tVille,tNss;
    Spinner sp;
    ArrayList<Etudiant> etds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_des_notes_json);
        tId=findViewById(R.id.jsonRident);
        tNom=findViewById(R.id.jsonRnom);
        tVille=findViewById(R.id.jsonRville);
        tNss=findViewById(R.id.jsonRnaissance);
        sp=findViewById(R.id.jsonRL);

        etds=getAllStudents();
        ArrayList<String> noms=new ArrayList<>();
        for(Etudiant e:etds){
            noms.add(e.getIdent()+" - "+e.getNom());
        }
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,noms);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
    public ArrayList<Etudiant> getAllStudents()
    {
        try {
            JSONArray arr=new JSONArray(lstJson(R.raw.resultats));
            ArrayList<Etudiant> ets=new ArrayList<>();
            for (int i=0;i<arr.length();i++)
            {
                JSONObject obj=arr.getJSONObject(i);
                Etudiant e=new Etudiant();
                e.setIdent(obj.getString("ident"));
                e.setNom(obj.getString("nom"));
                e.setVille(obj.getString("ville"));
                e.setDateNaissance(obj.getString("naissance"));
                e.setNoteFrns(obj.getJSONObject("resultat").getDouble("fr"));
                e.setNotehist(obj.getJSONObject("resultat").getDouble("hist"));
                e.setNotemath(obj.getJSONObject("resultat").getDouble("math"));
                e.setNotephys(obj.getJSONObject("resultat").getDouble("phys"));
                ets.add(e);

            }
            return  ets;
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}