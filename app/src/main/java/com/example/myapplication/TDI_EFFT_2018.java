package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TDI_EFFT_2018 extends AppCompatActivity {
    Button btnC, btnS;
    EditText txtVitesse;
    ImageView imgAguille;
    float i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdi_efft2018);
        btnC = findViewById(R.id.btnCEFF2018);
        btnS = findViewById(R.id.btnSEFF2018);
        txtVitesse = findViewById(R.id.txtVitesseEFF2018);
        imgAguille = findViewById(R.id.aguilleEFF);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtVitesse.getText().equals("")) {
                    Toast.makeText(TDI_EFFT_2018.this, "Value 0", Toast.LENGTH_SHORT).show();
                } else {
                    int v = Integer.valueOf(txtVitesse.getText().toString()) * 180 / 100;
                    RotateAnimation anim = new RotateAnimation(
                            i* 180 / 100,
                            v,
                            RotateAnimation.RELATIVE_TO_SELF,
                            0.5f,
                            RotateAnimation.RELATIVE_TO_SELF,
                            0.28f);
                    i=Integer.valueOf(txtVitesse.getText().toString());
                    anim.setDuration(3000);
                    anim.setFillAfter(true);
                    imgAguille.startAnimation(anim);
                }

            }
        });
    }
}