package com.example.flash_card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private final List<Card> cards;
    private onCardListener onCardListener;

    public CardAdapter(List<Card> cards, onCardListener onCardListener) {
        this.cards =  cards;
        this.onCardListener = onCardListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final ImageView photo;
        final TextView difficulty;

        onCardListener onCardListener;
        public ViewHolder(@NonNull View itemView, onCardListener onCardListener) {
            super(itemView);
            photo = itemView.findViewById(R.id.photoImageView);
            difficulty = itemView.findViewById(R.id.difficultyTextView);
            this.onCardListener = onCardListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCardListener.onCardListener(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        //Sending new instance of ViewHolder
        // One view = one item of the list
        return new ViewHolder(view, onCardListener);
    }

    // Is called everytime new data are loaded
    // and has to be displayed on a RecyclerView
    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.photo.setImageResource(card.image);
        holder.difficulty.setText("Difficulté: "+ card.question);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public interface onCardListener{
        void onCardListener(int position);
    }
}
