package com.example.sayacuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;
    String yaz="";
    Vibrator vibrator;
    MediaPlayer ses;
    ShareP shareP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context=getApplicationContext();
        shareP=ShareP.getInstance(this);
        vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        ses=MediaPlayer.create(this,R.raw.ses1);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.textView);
    }

    public void Arttir(View view) {
        shareP.sayac=shareP.sayac+1;

        if (shareP.sayac>= shareP.ustlimit){
            shareP.sayac=shareP.ustlimit;
            if (shareP.ustlimitses){
                Cal();
            }
        }
        yaz=Integer.toString(shareP.sayac);
        text.setText(yaz);
    }

    public void Azalt(View view) {
        shareP.sayac=shareP.sayac-1;

        if (shareP.sayac<= shareP.altlimit){
            shareP.sayac=shareP.altlimit;
            if (shareP.altlimitses){
                Cal();
            }
        }
        yaz=Integer.toString(shareP.sayac);
        text.setText(yaz);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        int aksiyon, keycode;
        aksiyon=event.getAction();
        keycode=event.getKeyCode();

        switch (keycode){
            case KeyEvent.KEYCODE_VOLUME_UP:{
                if(KeyEvent.ACTION_UP==aksiyon) {
                    shareP.sayac = shareP.sayac + 5;
                    if (shareP.sayac>= shareP.ustlimit) {
                        shareP.sayac = shareP.ustlimit;
                        if (shareP.ustlimitses){
                            Cal();
                        }
                        if (shareP.ustlimittitresim){
                            Vibrate();
                        }
                    }
                    yaz = Integer.toString(shareP.sayac);
                    text.setText(yaz);
                }
                break;
            }
            case KeyEvent.KEYCODE_VOLUME_DOWN:{
                if(KeyEvent.ACTION_DOWN==aksiyon) {
                    shareP.sayac = shareP.sayac - 5;
                    if (shareP.sayac<= shareP.altlimit){
                        shareP.sayac=shareP.altlimit;
                        if (shareP.altlimitses){
                            Cal();
                        }
                    }
                    yaz = Integer.toString(shareP.sayac);
                    text.setText(yaz);
                }
            }
        }
        return  super.dispatchKeyEvent(event);
    }

    public void ayar(View view) {
        Intent ıntent=new Intent(MainActivity.this,Ayarlar.class);
        startActivity(ıntent);
    }
    private void Cal(){
        ses.seekTo(0);
        ses.start();
        Toast.makeText(MainActivity.this,"girdi",Toast.LENGTH_SHORT).show();
    }
    private void Vibrate(){
        Log.d("Debug message","Titriyor");
        if(!vibrator.hasVibrator())
            return;
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            vibrator.vibrate(VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE));
        }else {
            vibrator.vibrate(1000);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        shareP.kaydedilendeger();
    }

    @Override
    protected void onResume() {
        super.onResume();
        yaz=Integer.toString(shareP.sayac);
        text.setText(yaz);
    }
}