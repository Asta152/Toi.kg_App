package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private ArrayList<CardItem> cardList;

    public CardAdapter(ArrayList<CardItem> cardList) {
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem cardItem = cardList.get(position);
        CardItem currentItem = cardList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResId());
        holder.titleTextView.setText(currentItem.getTitle());
        holder.categoryTextView.setText(currentItem.getCategory());
        holder.ratingTextView.setText("★ " + String.format(Locale.US, "%.1f", cardItem.getRating()));
        holder.seatsTextView.setText(" | мест: " + currentItem.getSeats());
        holder.priceTextView.setText("от " + currentItem.getPrice());
        holder.companyLogo.setImageResource(currentItem.getCompanyLogoResId());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, companyLogo;
        TextView titleTextView, categoryTextView, ratingTextView, seatsTextView, priceTextView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);
            titleTextView = itemView.findViewById(R.id.card_title);
            categoryTextView = itemView.findViewById(R.id.card_category);
            ratingTextView = itemView.findViewById(R.id.card_rating);
            seatsTextView = itemView.findViewById(R.id.card_seats);
            priceTextView = itemView.findViewById(R.id.card_price);
            companyLogo = itemView.findViewById(R.id.company_logo);
        }
    }
    public void filterList(ArrayList<CardItem> filteredList) {
        cardList = filteredList;
        notifyDataSetChanged();
    }
}
