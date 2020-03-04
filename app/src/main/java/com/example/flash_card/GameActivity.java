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

import java.util.List;

public class GameActivity extends AppCompatActivity {

    Card card;
    Quizz quizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        quizz = new Quizz();
        quizz.cards = List<card>


        card = new Card();
        card.image = R.drawable.hugo;
        card.question ="Qui est ce personnage historique ?";
        card.reponse1 ="Hugo";
        card.reponse2 ="Anthony";
        card.reponse3 ="Hugo-Anthony";
        card.reponse = "Hugo-Anthony";



        //TextView Suivie = findViewById(R.id.SuiviTextView);

        ImageView Question = findViewById(R.id.PhotoQuizz);
        Question.setImageResource(card.image);

        TextView  Quizz = findViewById(R.id.QuestionTextView);
        Quizz.setText(card.question);

        RadioButton numero_1 = findViewById(R.id.Reponse1);
        numero_1.setText(card.reponse1);

        RadioButton numero_2 = findViewById(R.id.Reponse2);
        numero_2.setText(card.reponse2);


        RadioButton numero_3 = findViewById(R.id.Reponse3);
        numero_3.setText(card.reponse3);

        final TextView Reponse = findViewById(R.id.RepTextView);


        Button validate = findViewById(R.id.ValidateButton);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent ValIntent = new Intent(GameActivity.this, GameActivity.class);
             Reponse.setText(card.reponse);



                //finish
                // startActivity(GameActivity);
            }
        });

    }

}
