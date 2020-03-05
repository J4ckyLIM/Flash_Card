package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class SingleCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_card);
        ImageView image = findViewById(R.id.photoImageView);
        final RadioButton rep1 = findViewById(R.id.answerRadioButton1);
        final RadioButton rep2 = findViewById(R.id.answerRadioButton2);
        final RadioButton rep3 = findViewById(R.id.answerRadioButton3);
        final Button returnButton = findViewById(R.id.returnButton);
        final TextView goodRep = findViewById(R.id.goodTextView);
        final TextView result = findViewById(R.id.resultTextView);
        // Get data from the "click"
        Intent srcIntent = getIntent();
        // Get back the card object
        final Card card = srcIntent.getParcelableExtra("card");
        image.setImageResource(card.image);
        rep1.setText(card.reponse1);
        rep2.setText(card.reponse2);
        rep3.setText(card.reponse3);
        rep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(rep1.getText().toString(), card.reponse, goodRep, result, v);
            }
        });

        rep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(rep2.getText().toString(), card.reponse, goodRep, result, v);
            }
        });
        rep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(rep3.getText().toString(), card.reponse, goodRep, result, v);
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleCardActivity.this, CardListActivity.class);
                startActivity(intent);
            }
        });
    }
    private void verifyAnswer(String answer, String goodAnswer, TextView goodRep, TextView result, View v){
        goodRep.setVisibility(v.VISIBLE);
        goodRep.setText("La bonne réponse est: " + goodAnswer);
        if(answer.equals(goodAnswer)){
            result.setText("Vrai !");
        }
        else{
            result.setText("Faux !");
        }
    }
}
