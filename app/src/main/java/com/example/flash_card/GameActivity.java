package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView image = findViewById(R.id.QuestionImageView);


        TextView question1 = findViewById(R.id.Question1TextView);


        TextView question2 = findViewById(R.id.Question2TextView);



        TextView question3 = findViewById(R.id.Question3TextView);

        TextView rep = findViewById(R.id.RepTextView);

        Button valider = findViewById(R.id.Validatebutton);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Faire l'ecran de fin EndActivity pour l'envoie de rep 
               // Intent validIntent = new Intent( GameActivity.this, EndActivity );

            }
        });
    }
}