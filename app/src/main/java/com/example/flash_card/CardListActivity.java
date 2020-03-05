package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CardListActivity extends AppCompatActivity implements CardAdapter.onCardListener{

    private CardAdapter adapter;
    private ArrayList<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
        setTitle("Toutes les questions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for(int i = 0; i  < 20; i++){
            // Adding fake data (should be data from db or api)
            cards.add(new Card(R.drawable.hugo, "EASY", "ok", "ok", "ok","ok"));
            cards.add(new Card(R.drawable.papy, "HARD", "ok", "ok", "ok","ok"));
        }

        adapter = new CardAdapter(cards, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onCardListener(int position) {
        Log.d("OKBOOMER", "onCardListener: clicked");
        //cards.get(position);
        Intent intent = new Intent(this, SingleCardActivity.class );
        intent.putExtra("image", "OK BOOMER");
        startActivity(intent);
    }
}
