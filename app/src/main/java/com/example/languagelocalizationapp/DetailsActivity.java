package com.example.languagelocalizationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.setTitle(MyApp.getInstance().getString("details"));

        String welcome=MyApp.getInstance().getString("welcome");              //getString by Name.

        String selectedLanguage=MyApp.getInstance().getString("selectedLanguage");

        Log.d("TAG",welcome+" "+selectedLanguage);

    }

}
