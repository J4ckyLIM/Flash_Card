package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flash_card.BuildConfig;

import android.os.Bundle;
import android.widget.TextView;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView versionName = findViewById(R.id.textVersion);
        versionName.setText("Version : " + BuildConfig.VERSION_NAME);

    }
    public static double Version = 1.0;

}
