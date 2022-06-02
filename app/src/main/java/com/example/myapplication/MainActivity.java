package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText t;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=findViewById(R.id.formEmail);
        res=findViewById(R.id.res);
        btn=findViewById(R.id.b);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Text is Empty !!!!!", Toast.LENGTH_SHORT).show();
                }
                else {

                        res.setText("Your Email is :: "+t.getText().toString());
                }
            }
        });
    }




}