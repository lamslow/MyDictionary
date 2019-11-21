package com.example.mydictionary.hoder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class EnglishHoder extends RecyclerView.ViewHolder {
    public TextView tvWordEnglish;
    public EnglishHoder(@NonNull View itemView) {
        super(itemView);
        tvWordEnglish=itemView.findViewById(R.id.tvWordEnglish);
    }
}
