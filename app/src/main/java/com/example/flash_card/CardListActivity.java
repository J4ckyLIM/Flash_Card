package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CardListActivity extends AppCompatActivity implements CardAdapter.onCardListener{

    private CardAdapter adapter;
    private ArrayList<Card> cards = new ArrayList<>();
    private String jsonString;
    private JSONArray jsonArray;
    private JSONObject jsonObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

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
                // Adding fake data (should be data from db or api)
                cards.add(new Card(imageId, jsonObj.getString("difficulty"), allAnswers.get(0), allAnswers.get(1), allAnswers.get(2), goodAnswer));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new CardAdapter(cards, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onCardListener(int position) {
        Card card = cards.get(position);
        Intent intent = new Intent(this, SingleCardActivity.class );
        intent.putExtra("card", card);
        startActivity(intent);
    }
}
