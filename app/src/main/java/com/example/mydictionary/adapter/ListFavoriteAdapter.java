package com.example.mydictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;
import com.example.mydictionary.dao.FavoriteDAO;
import com.example.mydictionary.hoder.ListFavoriteHoder;
import com.example.mydictionary.model.Favorite;

import java.util.List;

public class ListFavoriteAdapter extends RecyclerView.Adapter<ListFavoriteHoder> {
    private Context context;
    private List<Favorite> list;
    private FavoriteDAO favoriteDAO;

    public ListFavoriteAdapter(Context context, List<Favorite> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListFavoriteHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_favorite,parent,false);
        ListFavoriteHoder listFavoriteHoder=new ListFavoriteHoder(view);
        return listFavoriteHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListFavoriteHoder holder, final int position) {
    holder.tvWordFavorite.setText(list.get(position).getWordFavorite());
    holder.imgDelFav.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            favoriteDAO=new FavoriteDAO(context);
            int result=favoriteDAO.delFavorite(list.get(position).getWordFavorite());
            if (result>0){
                Toast.makeText(context, "Hủy yêu thích thành công", Toast.LENGTH_SHORT).show();
                list.remove(position);
                notifyDataSetChanged();
            }else {
                Toast.makeText(context, "Hủy yêu thích thất bai", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
