package com.example.mydictionary.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class ListFavoriteHolder extends RecyclerView.ViewHolder {
    public TextView tvWordFavorite;
    public ImageView imgDelFav;
    public ListFavoriteHolder(@NonNull View itemView) {
        super(itemView);
        tvWordFavorite=itemView.findViewById(R.id.tvWordFavorite);
        imgDelFav=itemView.findViewById(R.id.imgDelFav);
    }
}
