package com.example.flash_card;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SingleCardActivity extends AppCompatActivity {

    private static final int REQUEST_A = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_card);

        Intent srcIntent = getIntent();
        //int image = srcIntent.getIntExtra("image");
    }

}
