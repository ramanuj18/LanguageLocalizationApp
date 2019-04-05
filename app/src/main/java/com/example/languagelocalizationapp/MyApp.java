package com.example.languagelocalizationapp;

import android.app.Application;
import android.content.Context;

import com.example.languagelocalizationapp.helper.LocalHelper;

public class MyApp extends Application {

    private static MyApp INSTANCE;


    public static MyApp getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocalHelper.onAttach(base));
    }

    //get string by string name from string resource.
    public String getString(String stringName){
        int id= getResources().getIdentifier(stringName, "string", getPackageName());
        return getResources().getString(id);
    }

    //get array by array name from string resource.
    public  String[] getStringArray(String arrayName){
        int id=getResources().getIdentifier(arrayName, "array", getPackageName());
        return getResources().getStringArray(id);
    }

}
