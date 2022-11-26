package com.example.sayacuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class GIRIS_EKRANI extends AppCompatActivity {
    Handler h=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(GIRIS_EKRANI.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}