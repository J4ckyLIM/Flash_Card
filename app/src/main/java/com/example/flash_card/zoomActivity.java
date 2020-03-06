package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class zoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        Intent intent = getIntent();
       int photo =  intent.getIntExtra("aInt", 0);
        ImageView toto = findViewById(R.id.imageView5);
        toto.setImageResource(photo);
    }
}
