package com.example.mydictionary.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;
import com.example.mydictionary.activity.DetailVietNamWordActivity;
import com.example.mydictionary.holder.VietNamHoder;
import com.example.mydictionary.model.VietnameseWord;

import java.util.List;

public class VietNamAdapter extends RecyclerView.Adapter<VietNamHoder> {
    private Context context;
    private List<VietnameseWord> list;

    public VietNamAdapter(Context context, List<VietnameseWord> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public VietNamHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.vietnam,parent,false);
        VietNamHoder vietNamHoder=new VietNamHoder(view);
        return vietNamHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull VietNamHoder holder, final int position) {
        holder.tvWordVietnam.setText(list.get(position).word);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailVietNamWordActivity.class);
                intent.putExtra("vietnamWord",list.get(position).word);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
