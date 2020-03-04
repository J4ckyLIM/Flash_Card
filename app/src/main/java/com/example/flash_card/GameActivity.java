package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        card = new Card();
        card.image = R.drawable.hugo;
        card.question ="Qui est ce personnage historique";
        card.reponse1 ="Hugo";
        card.reponse2 ="Anthony";
        card.reponse3 ="Hugo-Anthony";
        card.reponse = "Hugo-Anthony";



        //TextView Suivie = findViewById(R.id.SuiviTextView);

        ImageView Question = findViewById(R.id.PhotoQuizz);
        Question.setImageResource(card.image);

        TextView  Quizz = findViewById(R.id.QuestionTextView);

        RadioButton numero_1 = findViewById(R.id.Reponse1);

        RadioButton numero_2 = findViewById(R.id.Reponse2);

        RadioButton numero_3 = findViewById(R.id.Reponse3);

        Button validate = findViewById(R.id.ValidateButton);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent ValIntent = new Intent(GameActivity.this, GameActivity.class);
             ValIntent.putExtra("aRep" , card.reponse);


                //finish
                // startActivity(GameActivity);
            }
        });

    }

}
