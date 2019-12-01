package com.example.mydictionary.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;
import com.example.mydictionary.activity.DetailWordActivity;
import com.example.mydictionary.dao.EnglishDAO;
import com.example.mydictionary.dao.FavoriteDAO;
import com.example.mydictionary.holder.ListFavoriteHolder;
import com.example.mydictionary.model.Favorite;
import com.example.mydictionary.model.Word;

import java.util.List;

public class ListFavoriteAdapter extends RecyclerView.Adapter<ListFavoriteHolder> {
    private Context context;
    private List<Favorite> list;
    private FavoriteDAO favoriteDAO;
    private EnglishDAO englishDAO;

    public ListFavoriteAdapter(Context context, List<Favorite> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListFavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_favorite, parent, false);
        ListFavoriteHolder listFavoriteHolder = new ListFavoriteHolder(view);
        return listFavoriteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListFavoriteHolder holder, final int position) {
        holder.tvWordFavorite.setText(list.get(position).getWordFavorite());
        holder.imgDelFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.dialog_fav, null);
                builder.setTitle("Bạn có muốn hủy yêu thích không");
                builder.setView(view);
                final AlertDialog dialog = builder.show();
                Button btnCancel, btnOk;
                btnCancel = dialog.findViewById(R.id.btnCancel);
                btnOk = dialog.findViewById(R.id.btnOk);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        favoriteDAO = new FavoriteDAO(context);
                        int result = favoriteDAO.delFavorite(list.get(position).getWordFavorite());
                        if (result > 0) {
                            Toast.makeText(context, "Hủy yêu thích thành công", Toast.LENGTH_SHORT).show();
                            list.remove(position);
                            notifyDataSetChanged();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(context, "Hủy yêu thích thất bai", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });


            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                englishDAO=new EnglishDAO(context);
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                Word word=englishDAO.searchWordByName(list.get(position).getWordFavorite());
                builder.setTitle(word.word);
                builder.setMessage(Html.fromHtml(word.html));
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
