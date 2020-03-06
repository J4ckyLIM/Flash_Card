package com.example.flash_card;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;
public class GameActivity extends AppCompatActivity {

    Card card;
    Quizz quizz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent srcIntent = getIntent();
        quizz = srcIntent.getParcelableExtra("quizz");
        Log.i("COUNT", "onCreate: "+ quizz.count);
        //quizz.cards = srcIntent.getParcelableArrayListExtra("cards");
        card = quizz.cards.get(quizz.count);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        String question = quizz.count + "/" + quizz.cards.size() ;

        final TextView Suivie = findViewById(R.id.SuiviTextView);
        Suivie.setText(question);



        final ImageView Question = findViewById(R.id.PhotoQuizz);
        Question.setImageResource(card.image);
        Question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this , zoomActivity.class);
                intent.putExtra("aInt" , card.image);
                startActivity(intent);
                Log.i("GAME", "jsuis a la fin");
            }
        });



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
                //ValIntent.putExtra("aInt", 0);
                ValIntent.putExtra("quizz", quizz);
                quizz.count++;
                if (card.reponse.equals(validate.getText())) {
                    quizz.ga++;
                    Reponse.setText("Bien ouej morray la bonne rep c'est :  " + card.reponse);

                }
                else {
                    Reponse.setText("Dommage Guignol c'etais pas loin la bonne reponse est : "  + card.reponse);
                }
               if ((quizz.cards.size() == quizz.count)){
                    Intent Resintent = new Intent(GameActivity.this, ResultActivity.class);
                    Resintent.putExtra("aString", quizz.cards.size());
                    Resintent.putExtra("aResult", quizz.ga);

                   try {
                       Thread.sleep(500);
                       startActivity(Resintent);

                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
            }
               else{
                   startActivity(ValIntent);
                   finish();
               }
            }
        });
    }
}