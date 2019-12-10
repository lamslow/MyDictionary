package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mydictionary.R;
import com.example.mydictionary.adapter.ListFavoriteVNAdapter;
import com.example.mydictionary.dao.VNFavoriteDAO;
import com.example.mydictionary.inter.VNFavoriteView;
import com.example.mydictionary.model.VNFavorite;
import com.example.mydictionary.presenter.VNFavoritePresenter;

import java.util.List;

public class ListFavoriteVNActivity extends AppCompatActivity implements VNFavoriteView {
    private Toolbar toolbar8;
    private RecyclerView rvListFavVN;
    List<VNFavorite> list;
    VNFavoriteDAO vnFavoriteDAO;
    private VNFavoritePresenter vnFavoritePresenter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_favorite_vn);


        toolbar8 = (Toolbar) findViewById(R.id.toolbar8);
        toolbar8.setTitle("Danh sách yêu thích");
        setSupportActionBar(toolbar8);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvListFavVN = (RecyclerView) findViewById(R.id.rvListFavVN);
        vnFavoritePresenter=new VNFavoritePresenter(this);
        vnFavoritePresenter.show();

    }

    @Override
    public void show() {
        vnFavoriteDAO=new VNFavoriteDAO(this);
        list=vnFavoriteDAO.getAllWordFavorite();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        ListFavoriteVNAdapter listFavoriteVNAdapter=new ListFavoriteVNAdapter(list,this);
        rvListFavVN.setLayoutManager(linearLayoutManager);
        rvListFavVN.setAdapter(listFavoriteVNAdapter);

    }
}
