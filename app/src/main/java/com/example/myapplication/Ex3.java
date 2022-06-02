package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ex3 extends AppCompatActivity {
    Button b;
    EditText t1;
    EditText t2;
    TextView res;
    ArrayList<Utilisateur> user=new ArrayList<Utilisateur>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
        b=findViewById(R.id.b);
        t1=findViewById(R.id.nom);
        t2=findViewById(R.id.password);
        res=findViewById(R.id.result);
        user.add(new Utilisateur("log1","pass1"));
        user.add(new Utilisateur("log2","pass2"));
        user.add(new Utilisateur("log3","pass3"));
        user.add(new Utilisateur("log4","pass4"));
        user.add(new Utilisateur("log5","pass5"));
        user.add(new Utilisateur("log6","pass6"));

    }
    public  void onClickHandler(View view){
        for(Utilisateur u:user){
            if(t1.getText().toString().equals(u.getLogin())&&t2.getText().toString().equals(u.getMotpass())){
                res.setText("Connection ok");
                //Toast.makeText(this, "hyhy", Toast.LENGTH_SHORT).show();
            }
            else {
                res.setText("Connection KO");
            }
        }
    }
}