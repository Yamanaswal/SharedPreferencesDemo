package com.example.sharedpreferencesdemo;


import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    /* Get the Context */
    Context context;

    public Preferences(Context context) {
        this.context = context;
    }

    public SharedPreferences sharedPreferences(){
        return context.getSharedPreferences("yaman",0);
    }

    //Clear Shared Preferences
    public void clearSp(){
        sharedPreferences().edit().clear().apply();
    }

    public void setName(String value){ sharedPreferences().edit().putString("name",value).apply(); }

    public String getname(){ return sharedPreferences().getString("name",""); }

    public void setPassword(String password){sharedPreferences().edit().putString("password",password).apply(); }

    public String getPassword(){ return sharedPreferences().getString("password",""); }

    public void setLogin(boolean b){  sharedPreferences().edit().putBoolean("login",b).apply();}

    public boolean isLogin(){return sharedPreferences().getBoolean("login",false);}

}
