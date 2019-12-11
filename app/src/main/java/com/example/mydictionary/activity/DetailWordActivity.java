package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydictionary.R;
import com.example.mydictionary.dao.EnglishDAO;
import com.example.mydictionary.dao.FavoriteDAO;
import com.example.mydictionary.databinding.ActivityDetailWordBinding;
import com.example.mydictionary.inter.DetailWordView;
import com.example.mydictionary.model.Favorite;
import com.example.mydictionary.model.VNFavorite;
import com.example.mydictionary.model.VietnameseWord;
import com.example.mydictionary.model.Word;
import com.example.mydictionary.presenter.AddFavoritePresenter;

import java.util.List;

public class DetailWordActivity extends AppCompatActivity implements DetailWordView {
    private EnglishDAO englishDAO;
    private AddFavoritePresenter addFavoritePresenter;
    private FavoriteDAO favoriteDAO;
    ImageView imgFav;
    Toolbar toolbar7;
    private List<Favorite> favoriteList;
    ActivityDetailWordBinding activityDetailWordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailWordBinding = DataBindingUtil.setContentView
                (this, R.layout.activity_detail_word);
        addFavoritePresenter = new AddFavoritePresenter(this);
        activityDetailWordBinding.setAddFav(addFavoritePresenter);
        toolbar7 = findViewById(R.id.toolbar7);
        toolbar7.setTitle("My Dictionary");
        setSupportActionBar(toolbar7);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        imgFav = findViewById(R.id.imgFav);
        englishDAO = new EnglishDAO(this);
        favoriteDAO = new FavoriteDAO(this);
        addFavoritePresenter.show();
    }


    @Override
    public void addFavorite() {
        Favorite favorite = new Favorite();
        favorite.setWordFavorite(activityDetailWordBinding.getShowDetail().word);
        long result = favoriteDAO.insertFavorite(favorite);
        if (result > 0) {
            Toast.makeText(this, "Bạn đã thêm thành công vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
            int id = R.drawable.star;
            imgFav.setImageResource(id);
        } else {
            Toast.makeText(this, "Từ đã có trong danh sách yêu thích", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void show() {
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        Log.e("abc", data + "");
        Word word = englishDAO.searchWordByName(data);
        activityDetailWordBinding.setShowDetail(word);
        favoriteList = favoriteDAO.getAllWordFavorite();
        for (int i = 0; i < favoriteList.size(); i++) {
            Favorite favorite = favoriteList.get(i);
            if (favorite.getWordFavorite().equalsIgnoreCase(activityDetailWordBinding.getShowDetail().word)) {
                imgFav.setImageResource(R.drawable.star);
            } else {

            }
        }
    }


}
