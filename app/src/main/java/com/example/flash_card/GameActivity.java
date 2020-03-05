package com.example.flash_card;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
public class GameActivity extends AppCompatActivity {


    Card card;
    Quizz quizz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        quizz = new Quizz();
        quizz.cards = new ArrayList<>();
        quizz.ga = 0;
        quizz.count = 0;
        card = new Card(R.drawable.hugo, "Qui est ce personnage historique ?", "Hugo", "Anthony", "Hugo-Anthony","Hugo-Anthony" );
        quizz.cards.add(card);
        //quizz.cards.get(0).image

        String question = quizz.count + "/" + quizz.cards.size() ;

        final TextView Suivie = findViewById(R.id.SuiviTextView);
        Suivie.setText(question);



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
        final RadioGroup radioQuestion = findViewById(R.id.QuestionRadioGroup);
        final TextView Reponse = findViewById(R.id.RepTextView);
        final Button validate = findViewById(R.id.ValidateButton);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioQuestion.getCheckedRadioButtonId();
                RadioButton validate = findViewById(selectedId);

                Intent ValIntent = new Intent(GameActivity.this, GameActivity.class);
                Reponse.setText(card.reponse);

                Suivie.setText(quizz.count++ + "/" + quizz.cards.size());

                if (card.reponse.equals(validate.getText())) {
                    quizz.ga++;
                    Log.i("GAME" , ""+quizz.ga);
                }
               if ((quizz.cards.size() == quizz.count)){
                    Log.i("GameActivity", "COUCOU");
                    Intent Resintent = new Intent(GameActivity.this, ResultActivity.class);
                    Resintent.putExtra("aString", quizz.cards.size());
                    Resintent.putExtra("aResult", quizz.ga);

                   try {
                       Suivie.setText(quizz.count++ + "/" + quizz.cards.size());
                       Thread.sleep(5000);
                       startActivity(Resintent);

                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }




            }
              //  finish();
               // startActivity(GameActivity.this);
            }
        });
    }
}