package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerConversionDistances extends AppCompatActivity {
    Button btnC;
    TextView res;
    Spinner sFrom,sTo;
    EditText v;
    Double from=0.0;
    Double to=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_conversion_distances);
        btnC=findViewById(R.id.btnConversionD);
        res=findViewById(R.id.resConversionD);
        sFrom=(Spinner) findViewById(R.id.fromConversionD);
        sTo=(Spinner)findViewById(R.id.toConversionD);
        v=findViewById(R.id.valueConversionD);
        String[] unites={"m","km","hm","dam","dc","cm","mm"};
        Double[] unitesValues={1.0,0.001,0.01,0.1,10.0,100.0,1000.0};
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,unites);
        sFrom.setAdapter(ad);
        sTo.setAdapter(ad);
        sFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(SpinnerConversionDistances.this, "ff/"+i+unites[i], Toast.LENGTH_SHORT).show();
                from=(Double) unitesValues[i];

                //Double resV=
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                to=(Double) unitesValues[i];
                Toast.makeText(SpinnerConversionDistances.this, "kk/"+i, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double vEntrez= Double.valueOf(v.getText().toString());
                Double k=(vEntrez*to)/from;
                res.setText(k.toString());
            }
        });
    }
}