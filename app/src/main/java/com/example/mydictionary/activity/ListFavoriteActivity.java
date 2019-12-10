package com.example.mydictionary.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mydictionary.R;
import com.example.mydictionary.adapter.ListFavoriteAdapter;
import com.example.mydictionary.dao.EnglishDAO;
import com.example.mydictionary.dao.FavoriteDAO;
import com.example.mydictionary.inter.ListFavoriteView;
import com.example.mydictionary.model.Favorite;
import com.example.mydictionary.presenter.ShowListFavoritePresenter;

import java.util.List;

public class ListFavoriteActivity extends AppCompatActivity implements ListFavoriteView {
    private Toolbar toolbar6;
    private FavoriteDAO favoriteDAO;
    private RecyclerView rvListFavorite;
    private EnglishDAO englishDAO;
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
        englishDAO=new EnglishDAO(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menufav,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.itVnFav){
            Intent intent=new Intent(this,ListFavoriteVNActivity.class);
            startActivity(intent);
        }else if (item.getItemId()== R.id.itHomePage){
            Intent intent=new Intent(this,HomePageActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
