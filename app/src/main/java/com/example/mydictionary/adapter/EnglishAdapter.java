package com.example.mydictionary.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;
import com.example.mydictionary.activity.DetailWordActivity;
import com.example.mydictionary.hoder.EnglishHoder;
import com.example.mydictionary.model.Word;

import java.util.List;

public class EnglishAdapter extends RecyclerView.Adapter<EnglishHoder> {
    private Context context;
    private List<Word> list;

    public EnglishAdapter(Context context, List<Word> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EnglishHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.english,parent,false);
        EnglishHoder english=new EnglishHoder(view);
        return english;
    }

    @Override
    public void onBindViewHolder(@NonNull EnglishHoder holder, int position) {
        holder.tvWordEnglish.setText(list.get(position).word);
        holder.tvWordEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailWordActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
