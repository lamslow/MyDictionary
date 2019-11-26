package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mydictionary.R;
import com.example.mydictionary.adapter.ListFavoriteAdapter;
import com.example.mydictionary.dao.FavoriteDAO;
import com.example.mydictionary.inter.ListFavoriteView;
import com.example.mydictionary.model.Favorite;
import com.example.mydictionary.presenter.ShowListFavoritePresenter;

import java.util.List;

public class ListFavoriteActivity extends AppCompatActivity implements ListFavoriteView {
    private Toolbar toolbar6;
    private FavoriteDAO favoriteDAO;
    private RecyclerView rvListFavorite;
    private List<Favorite> list;
    private ShowListFavoritePresenter showListFavoritePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_favorite);
        toolbar6 = findViewById(R.id.toolbar6);
        toolbar6.setTitle("Danh sách yêu thích");
        setSupportActionBar(toolbar6);
        rvListFavorite = findViewById(R.id.rvListFarite);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        favoriteDAO = new FavoriteDAO(this);
        showListFavoritePresenter=new ShowListFavoritePresenter(this);
        showListFavoritePresenter.ShowListFavorite();
    }

    @Override
    public void showListFav() {
        list = favoriteDAO.getAllWordFavorite();
        ListFavoriteAdapter listFavoriteAdapter=new ListFavoriteAdapter(this,list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvListFavorite.setLayoutManager(linearLayoutManager);
        rvListFavorite.setAdapter(listFavoriteAdapter);
    }
}
