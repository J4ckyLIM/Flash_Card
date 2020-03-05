package com.example.flash_card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class CardListActivity extends AppCompatActivity implements CardAdapter.onCardListener{

    private CardAdapter adapter;
    private ArrayList<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        for(int i = 0; i  < 20; i++){
            // Adding fake data (should be data from db or api)
            cards.add(new Card(R.drawable.hugo, "EASY", "ok", "NON", "peut etre","ok"));
            cards.add(new Card(R.drawable.papy, "HARD", "ok", "Hum", "MAIS NON","ok"));
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
