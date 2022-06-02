package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Exe2 extends AppCompatActivity implements View.OnClickListener {
    Button btnSomme;
    Button btnSoustraction;
    Button btnProduit;
    Button btnDivision;
    EditText nb1;
    EditText nb2;
    EditText Res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe2);
        btnSomme = findViewById(R.id.btnSomme);
        btnSoustraction = findViewById(R.id.btnSOUSTRACTION);
        btnProduit = findViewById(R.id.btnPRODUIT);
        btnDivision = findViewById(R.id.btnDIVISION);
        nb1 = findViewById(R.id.nb1);
        nb2 = findViewById(R.id.nb2);
        Res = findViewById(R.id.Res);
        btnSomme.setOnClickListener(this);
        btnSoustraction.setOnClickListener(this);
        btnProduit.setOnClickListener(this);
        btnDivision.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSomme) {
            int r = Integer.valueOf(nb1.getText().toString()) + Integer.valueOf(nb2.getText().toString());
            Res.setText(String.valueOf(r));
        }
        if (view.getId() == R.id.btnSOUSTRACTION) {
            int r = Integer.valueOf(nb1.getText().toString()) - Integer.valueOf(nb2.getText().toString());
            Res.setText(String.valueOf(r));
        }
        if (view.getId() == R.id.btnPRODUIT) {
            int r = Integer.valueOf(nb1.getText().toString()) * Integer.valueOf(nb2.getText().toString());
            Res.setText(String.valueOf(r));
        }
        if (view.getId() == R.id.btnDIVISION) {
            int r = Integer.valueOf(nb1.getText().toString()) / Integer.valueOf(nb2.getText().toString());
            Res.setText(String.valueOf(r));
        }
    }
}