package com.example.mydictionary.holder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class HistoryHolder extends RecyclerView.ViewHolder {
    public TextView tvWordHis;
    public ImageView imgDelHis;
    public HistoryHolder(@NonNull View itemView) {
        super(itemView);
        tvWordHis=itemView.findViewById(R.id.tvWordHis);
        imgDelHis=itemView.findViewById(R.id.imgDelHis);
    }
}
