package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TextModifeirExe4 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup rGColors, rGTailles;
    CheckBox chGras, chItalic;
    TextView mainR;

    /////

    RadioGroup rGUnit;
    CheckBox chInterP;
    TextView ResultatPoids;
    EditText txtPoids, txtTaille;
    Button btnimc, btnRaz;
    Double i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_modifeir_exe4);
        rGColors = findViewById(R.id.RadioGroupColors);
        mainR = findViewById(R.id.resultText);
        rGTailles = findViewById(R.id.RadioGroupTaille);
        chGras = findViewById(R.id.checkBGras);
        chItalic = findViewById(R.id.checkBItalic);
        rGColors.setOnCheckedChangeListener(this);
        rGTailles.setOnCheckedChangeListener(this);
        chGras.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chItalic.isChecked() && chGras.isChecked()) {
                    mainR.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));

                } else if (chGras.isChecked()) {
                    mainR.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

                } else {
                    mainR.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));

                }
            }
        });
        chItalic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chItalic.isChecked() && chGras.isChecked()) {
                    mainR.hasFocus();
                    mainR.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));

                } else if (chItalic.isChecked()) {
                    mainR.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));

                } else {
                    mainR.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));

                }
            }
        });
        //////Exercice 5
        rGUnit = findViewById(R.id.rGUnit);
        chInterP = findViewById(R.id.ChAfficheInter);
        ResultatPoids = findViewById(R.id.ResultatPoids);
        btnimc = findViewById(R.id.imc);
        btnRaz = findViewById(R.id.RAZ);
        txtPoids = findViewById(R.id.IdPoids);
        txtTaille = findViewById(R.id.IdTaille);

        btnRaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultatPoids.setText("");
                txtPoids.setText("");
                txtTaille.setText("");
                rGUnit.clearCheck();
                chInterP.setChecked(false);
            }
        });
        btnimc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rGUnit.getCheckedRadioButtonId() == R.id.rdM) {
                    i = Double.valueOf(txtPoids.getText().toString()) / Double.valueOf(txtTaille.getText().toString());
                    ResultatPoids.setText(i.toString());
                }
                if (rGUnit.getCheckedRadioButtonId() == R.id.rdCm) {
                    Double k=Double.valueOf(txtTaille.getText().toString())/100;
                    i = Double.valueOf(txtPoids.getText().toString())/k;
                    ResultatPoids.setText(i.toString());
                }
            }
        });
        chInterP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chInterP.isChecked()){
                    if(i<18.5){
                        ResultatPoids.setText(ResultatPoids.getText().toString()+'\n'+"insuffisance pondérale");
                    }
                    if(i>18.5 && i<24.9){
                        ResultatPoids.setText(ResultatPoids.getText().toString()+'\n'+"poids normal");
                    }
                    if(i>25 && i<29.9){
                        ResultatPoids.setText(ResultatPoids.getText().toString()+'\n'+"surpoids");
                    }
                    if(i>30){
                        ResultatPoids.setText(ResultatPoids.getText().toString()+'\n'+"obésité");
                    }
                }
                else {

                }
            }
        });
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Toast.makeText(this, "effefe", Toast.LENGTH_SHORT).show();
        if (rGColors.getCheckedRadioButtonId() == R.id.rdNoir) {
            mainR.setTextColor(Color.BLACK);
        }
        if (rGColors.getCheckedRadioButtonId() == R.id.rdRouge) {
            mainR.setTextColor(Color.RED);
        }
        if (rGColors.getCheckedRadioButtonId() == R.id.rdJaune) {
            mainR.setTextColor(Color.YELLOW);
        }
        if (rGColors.getCheckedRadioButtonId() == R.id.rdBleu) {
            mainR.setTextColor(Color.BLUE);
        }
        if (rGTailles.getCheckedRadioButtonId() == R.id.rd30dp) {
            mainR.setTextSize(30);
        }
        if (rGTailles.getCheckedRadioButtonId() == R.id.rd40dp) {
            mainR.setTextSize(40);
        }
        if (rGTailles.getCheckedRadioButtonId() == R.id.rd50dp) {
            mainR.setTextSize(50);
        }
        if (rGTailles.getCheckedRadioButtonId() == R.id.rd60dp) {
            mainR.setTextSize(60);
        }
    }
}