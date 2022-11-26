package com.example.sayacuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class Ayarlar extends AppCompatActivity {

    public int artisinir;
    public int eksisinir;

    EditText arti;
    Switch ustLimitSesi;
    Switch ustLimitTitresimi;

    EditText eksi;
    Switch altLimitSesi;
    Switch altLimitTitresimi;

    ShareP shareP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);
        shareP=ShareP.getInstance(this);

        arti.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(arti.getText().toString().length()==0){
                    arti.setText("0");
                    shareP.ustlimit=0;
                }else{
                    shareP.ustlimit=Integer.valueOf(arti.getText().toString());
                }
            }
        });
        ustLimitSesi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                shareP.ustlimitses=b;
            }
        });
        ustLimitTitresimi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                shareP.ustlimittitresim=b;
            }
        });
        ustLimitTitresimi=(Switch) findViewById(R.id.switch2);
        ustLimitSesi=(Switch) findViewById(R.id.switch1);
        altLimitSesi=(Switch) findViewById(R.id.switch1);
        altLimitTitresimi=(Switch) findViewById(R.id.switch2);


        eksi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(eksi.getText().toString().length()==0){
                    eksi.setText("0");
                    shareP.altlimit=0;
                }else{
                    shareP.altlimit=Integer.valueOf(eksi.getText().toString());
                }
            }
        });
        altLimitSesi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                shareP.altlimitses=b;
            }
        });
        altLimitTitresimi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                shareP.altlimittitresim=b;
            }
        });
        altLimitTitresimi=(Switch) findViewById(R.id.switch2);
        altLimitSesi=(Switch) findViewById(R.id.switch1);
        altLimitSesi=(Switch) findViewById(R.id.switch1);
        altLimitTitresimi=(Switch) findViewById(R.id.switch2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        arti.setText(String.valueOf(shareP.ustlimit));
        ustLimitSesi.setChecked(shareP.ustlimitses);
        ustLimitTitresimi.setChecked(shareP.ustlimittitresim);

        eksi.setText(String.valueOf(shareP.ustlimit));
        altLimitSesi.setChecked(shareP.altlimitses);
        altLimitTitresimi.setChecked(shareP.altlimittitresim);
    }

    @Override
    protected void onPause() {
        super.onPause();
        shareP.kaydedilendeger();
    }

    public void geridön(View view) {
        Intent ıntent=new Intent(Ayarlar.this,MainActivity.class);
        startActivity(ıntent);
    }


}