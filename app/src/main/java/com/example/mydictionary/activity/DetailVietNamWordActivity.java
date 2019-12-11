package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydictionary.R;
import com.example.mydictionary.dao.VNFavoriteDAO;
import com.example.mydictionary.dao.VietnameseDAO;
import com.example.mydictionary.databinding.ActivityDetailVietNamWordBinding;
import com.example.mydictionary.inter.DetailWordVNView;
import com.example.mydictionary.inter.DetailWordView;
import com.example.mydictionary.model.Favorite;
import com.example.mydictionary.model.VNFavorite;
import com.example.mydictionary.model.VietnameseWord;
import com.example.mydictionary.presenter.ShowDetailVNPresenter;

import java.util.List;

public class DetailVietNamWordActivity extends AppCompatActivity implements DetailWordVNView {
    private VietnameseDAO vietnameseDAO;
    private VNFavoriteDAO vnFavoriteDAO;
    private ImageView imgFav;
    private Toolbar toolbar7;
    ActivityDetailVietNamWordBinding activityDetailVietNamWordBinding;
    ShowDetailVNPresenter showDetailVNPresenter;
    private List<VNFavorite> vnFavoriteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailVietNamWordBinding = DataBindingUtil.setContentView
                (this, R.layout.activity_detail_viet_nam_word);
        showDetailVNPresenter = new ShowDetailVNPresenter(this);
        activityDetailVietNamWordBinding.setShowDetailVN(showDetailVNPresenter);
        imgFav = (ImageView) findViewById(R.id.imgFav);
        toolbar7 = (Toolbar) findViewById(R.id.toolbar7);
        toolbar7.setTitle("My Dictionary");
        setSupportActionBar(toolbar7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        vnFavoriteDAO = new VNFavoriteDAO(this);
        vietnameseDAO = new VietnameseDAO(this);
        showDetailVNPresenter.show();

    }

    @Override
    public void addFav() {
        VNFavorite favorite = new VNFavorite();
        favorite.setVnFavoriteword(activityDetailVietNamWordBinding.getDetailVN().word);
        long result = vnFavoriteDAO.insertFavorite(favorite);
        if (result > 0) {
            Toast.makeText(this, "Bạn đã thêm thành công vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
            int id = R.drawable.star;
            imgFav.setImageResource(id);
        } else {
            Toast.makeText(this, "Từ đã có trong danh sách yêu thích", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showDetailVN() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("vietnamWord");
        VietnameseWord vietnameseWord = vietnameseDAO.searchVNWordByName(text);
        activityDetailVietNamWordBinding.setDetailVN(vietnameseWord);
        vnFavoriteList = vnFavoriteDAO.getAllWordFavorite();
        for (int i = 0; i < vnFavoriteList.size(); i++) {
            VNFavorite vnFavorite = vnFavoriteList.get(i);
            if (vnFavorite.getVnFavoriteword().equalsIgnoreCase(activityDetailVietNamWordBinding.getDetailVN().word)) {
                imgFav.setImageResource(R.drawable.star);
            } else {

            }
        }

    }

}
