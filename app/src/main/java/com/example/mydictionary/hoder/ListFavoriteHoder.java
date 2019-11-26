package com.example.mydictionary.hoder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class ListFavoriteHoder extends RecyclerView.ViewHolder {
    public TextView tvWordFavorite;
    public ImageView imgDelFav;
    public ListFavoriteHoder(@NonNull View itemView) {
        super(itemView);
        tvWordFavorite=itemView.findViewById(R.id.tvWordFavorite);
        imgDelFav=itemView.findViewById(R.id.imgDelFav);
    }
}
