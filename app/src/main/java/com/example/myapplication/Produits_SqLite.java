package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Produits_SqLite extends AppCompatActivity {
    Spinner sp;
    MyDbProduit db;
    Button btnM,btnS,btnA;
    EditText txtId,txtL,txtF,txtAchat,txtVente;
    ProduitsClass pr;
    ArrayAdapter ad;
    ArrayList<ProduitsClass> sts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits_sq_lite);
        db=new MyDbProduit(this);
        sp=findViewById(R.id.spinnerPrdSqLite);
        btnM=findViewById(R.id.btnMPrdSqLite);
        btnS=findViewById(R.id.btnSPrdSqLite);
        btnA=findViewById(R.id.btnAPrdSqLite);
        txtId=findViewById(R.id.idPrdSqLite);
        txtL=findViewById(R.id.LibellePrdSqLite);
        txtF=findViewById(R.id.FamillePrdSqLite);
        txtAchat=findViewById(R.id.PrixAPrdSqLite);
        txtVente=findViewById(R.id.PrixVPrdSqLite);
        //

        sts = MyDbProduit.getAllProduits(db.getReadableDatabase());
        ArrayList<String> noms=new ArrayList<>();
        for(ProduitsClass s:sts) {
            noms.add(s.getLibelle()) ;
        }
        ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,noms);
        sp.setAdapter(ad);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProduitsClass pr1=new ProduitsClass(txtL.getText().toString(),txtF.getText().toString(),Double.valueOf(txtAchat.getText().toString()),Double.valueOf(txtVente.getText().toString()));
                long r=MyDbProduit.insertPrduits(db.getWritableDatabase(),pr1);

                if(r!=-1){
                    Toast.makeText(getApplicationContext(),"Insertion Reussie",Toast.LENGTH_LONG).show();
                    ad.add(pr1.getLibelle());
                }else{
                    Toast.makeText(getApplicationContext(),"Insertion Echoue",Toast.LENGTH_LONG).show();
                }

            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                 pr=sts.get(i);
                txtId.setText(String.valueOf(pr.getId()));
                txtL.setText(String.valueOf(pr.getLibelle()));
                txtF.setText(String.valueOf(pr.getFamille()));
                txtAchat.setText(String.valueOf(pr.getPrixAchat()));
                txtVente.setText(String.valueOf(pr.getPrixVente()));
                Toast.makeText(Produits_SqLite.this, String.valueOf(pr.getFamille()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long r=MyDbProduit.updatePrduits(db.getWritableDatabase(),pr);

                if(r!=-1){
                    Toast.makeText(getApplicationContext(),"Update Reussie"+pr.getId(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Update Echoue",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}