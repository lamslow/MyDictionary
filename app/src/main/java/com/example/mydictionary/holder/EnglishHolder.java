package com.example.mydictionary.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class EnglishHolder extends RecyclerView.ViewHolder {
    public TextView tvWordEnglish;
    public EnglishHolder(@NonNull View itemView) {
        super(itemView);
        tvWordEnglish=itemView.findViewById(R.id.tvWordEnglish);
    }
}
