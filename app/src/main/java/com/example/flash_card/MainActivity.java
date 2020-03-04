package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String title = "Bienvenue sur l'application flash card";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView appTitleTextView = findViewById(R.id.appTitleTextView);
        appTitleTextView.setText(title);

        findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
                if(difficultyRadioGroup.getVisibility() == View.INVISIBLE){
                    difficultyRadioGroup.setVisibility(View.VISIBLE);
                }
                else {
                    difficultyRadioGroup.setVisibility(View.INVISIBLE);
                }*/

                // Open the difficulty popup
                Intent intent = new Intent(MainActivity.this, DifficultyChooserActivity.class);
                startActivity(intent);
            }
        });
    }


}
