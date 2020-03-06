package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DifficultyChooserActivity extends AppCompatActivity {

    private ArrayList<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_chooser);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        // Set popup size (window)
        getWindow().setLayout((int) (width * .9), (int) (height * .4));
        // Animation when popup disappear
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        Button facile = findViewById(R.id.easyRadioButton);
        Button mediumButton = findViewById(R.id. normalRadioButton);
        Button hardButton = findViewById(R.id.hardRadioButton);
        facile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCardForDifficulty("easy");
            }
        });
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCardForDifficulty("medium");
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCardForDifficulty("hard");
            }
        });
        findViewById(R.id.returnButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getCardForDifficulty(String difficulty) {
        Quizz quizz = new Quizz();
        quizz.ga = 0;
        quizz.count = 0;
        quizz.cards = new ArrayList<>();
        String jsonString = "";
        JSONArray jsonArray;
        JSONObject jsonObj;
        try {
            InputStream reader = getAssets().open("data.json");
            int size = reader.available();
            byte[] buffer = new byte[size];
            reader.read(buffer);
            reader.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            jsonArray = new JSONArray(jsonString);
            for(int i = 0; i  < jsonArray.length(); i++){
                // Initiate the variable that will store the good answer
                String goodAnswer = "";
                // Initiate the array that will contain the answers for a question
                ArrayList<String> allAnswers = new ArrayList<>();
                jsonObj = jsonArray.getJSONObject(i);
                // Get an array of all the answers
                JSONArray answers = jsonObj.getJSONArray("answers");
                // Split the image string to remove things after the "." like .jpeg or .png
                String[] imageArray = jsonObj.getString("image").split("\\.");
                String image = imageArray[0];
                int imageId = getResources().getIdentifier(image, "drawable", getPackageName());

                for(int j = 0; j < answers.length(); j++){
                    // Add the answer in the array
                    JSONObject answerObj = answers.getJSONObject(j);
                    String answer = answerObj.getString("sentence");
                    Boolean isGood = answerObj.getBoolean("is_right");
                    allAnswers.add(answer);
                    // If we find the answer that is true then we can store it
                    if(isGood){
                        goodAnswer = answer;
                    }
                }
                // Filter difficulty
                if(jsonObj.getString("difficulty").equals(difficulty)){
                    // Adding fake data (should be data from db or api)
                    quizz.cards.add(new Card(imageId, jsonObj.getString("difficulty"), allAnswers.get(0), allAnswers.get(1), allAnswers.get(2), goodAnswer));
                }
                // Send cards to the next intent
                Intent intent = new Intent(DifficultyChooserActivity.this, GameActivity.class);
                //intent.putExtra("cards", cards);
                intent.putExtra("quizz", quizz);
                startActivity(intent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
