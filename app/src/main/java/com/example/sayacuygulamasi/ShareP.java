package com.example.sayacuygulamasi;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareP {
    private static ShareP a;
    public int sayac;
    public int ustlimit;
    public boolean ustlimitses;
    public boolean ustlimittitresim;
    public int altlimit;
    public boolean altlimitses;
    public boolean altlimittitresim;
    private static final String KEY_CONTERVALUE="sayac";

    private static final String KEY_UPLIMIT="UstLimit";
    private static final String KEY_UPLIMIT_SES="UstLimit_ses";
    private static final String KEY_UPLIMIT_TIT="UstLimit_titresim";

    private static final String KEY_LOWWERLIMIT="AltLimit";
    private static final String KEY_LOWWERLIMIT_SES="AltLimit_ses";
    private static final String KEY_LOWWERLIMIT_TIT="AltLimit_titresim";

    private SharedPreferences shareP;
    private ShareP(Context context){
        shareP=context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
        yuklenendeger();
    }
    public static ShareP getInstance(Context context){
        if (a==null){
            a=new ShareP(context);
        }
        return a;
    }

    private void yuklenendeger() {
        sayac=shareP.getInt(KEY_CONTERVALUE,0);

        ustlimit=shareP.getInt(KEY_UPLIMIT,30);
        ustlimitses=shareP.getBoolean(KEY_UPLIMIT_SES,true);
        ustlimittitresim=shareP.getBoolean(KEY_UPLIMIT_TIT,true);

        altlimit=shareP.getInt(KEY_LOWWERLIMIT,0);
        altlimitses=shareP.getBoolean(KEY_LOWWERLIMIT_SES,true);
        altlimittitresim=shareP.getBoolean(KEY_LOWWERLIMIT_TIT,true);

    }
    public void kaydedilendeger(){
        SharedPreferences.Editor editor=shareP.edit();

        editor.putInt(KEY_CONTERVALUE,sayac);

        editor.putInt(KEY_UPLIMIT,ustlimit);
        editor.putBoolean(KEY_UPLIMIT_SES,ustlimitses);
        editor.putBoolean(KEY_UPLIMIT_TIT,ustlimittitresim);

        editor.putInt(KEY_LOWWERLIMIT,altlimit);
        editor.putBoolean(KEY_LOWWERLIMIT_SES,altlimitses);
        editor.putBoolean(KEY_LOWWERLIMIT_TIT,altlimittitresim);

        editor.commit();
    }
}
