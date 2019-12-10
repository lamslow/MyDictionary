package com.example.mydictionary.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class VietNamHoder extends RecyclerView.ViewHolder {
    public TextView tvWordVietnam;
    public VietNamHoder(@NonNull View itemView) {
        super(itemView);
        tvWordVietnam=itemView.findViewById(R.id.tvWordVietnam);
    }
}
