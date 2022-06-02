package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;

public class IntentsPageLogin extends AppCompatActivity {
    ArrayList<UsersForIntents> user=new ArrayList<UsersForIntents>();
    Button b;
    EditText t1;
    EditText t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_page_login);
        b=findViewById(R.id.btnConnecter);
        t1=findViewById(R.id.LoginI);
        t2=findViewById(R.id.passwordI);

        user.add(new UsersForIntents("log1","123456","Ahmed","Ahmedi",new Date(2000,2,20),1));
        user.add(new UsersForIntents("log2","123456","Ilyas","Ilyasi",new Date(2000,2,20),2));
        user.add(new UsersForIntents("log3","123456","Anas","Anasi",new Date(2000,2,20),3));
        user.add(new UsersForIntents("log4","123456","Mohamed","Mohamedi",new Date(2000,2,20),4));
        user.add(new UsersForIntents("log5","123456","Zakaria","Zakariai",new Date(2000,2,20),5));
        user.add(new UsersForIntents("log6","123456","Youssef","Youssefi",new Date(2000,2,20),6));
    }

    public void OnclickH(View view) {
        for(UsersForIntents u:user){
            if(t1.getText().toString().equals(u.getLogin())&&t2.getText().toString().equals(u.getPassword())){
                Intent i=new Intent(IntentsPageLogin.this,IntentsPageShow.class);
                i.putExtra("UserObj",u);
                startActivity(i);
                //Toast.makeText(this, "hyhy", Toast.LENGTH_SHORT).show();
            }
            else {

            }
        }
    }
}