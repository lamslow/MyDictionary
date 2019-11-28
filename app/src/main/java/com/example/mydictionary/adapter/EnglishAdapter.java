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
import com.example.mydictionary.holder.EnglishHolder;
import com.example.mydictionary.model.Word;

import java.util.List;

public class EnglishAdapter extends RecyclerView.Adapter<EnglishHolder> {
    private Context context;
    private List<Word> list;

    public EnglishAdapter(Context context, List<Word> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EnglishHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.english,parent,false);
        EnglishHolder english=new EnglishHolder(view);
        return english;
    }

    @Override
    public void onBindViewHolder(@NonNull EnglishHolder holder, final int position) {
        holder.tvWordEnglish.setText(list.get(position).word);
        holder.tvWordEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailWordActivity.class);
                intent.putExtra("data",list.get(position).word);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
