package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mydictionary.R;
import com.example.mydictionary.databinding.ActivityHomePageBinding;
import com.example.mydictionary.inter.HomePageView;
import com.example.mydictionary.presenter.HomePagePresenter;

public class HomePageActivity extends AppCompatActivity implements HomePageView {
    private Toolbar toolbar;
    private HomePagePresenter homePagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomePageBinding activityHomePageBinding= DataBindingUtil.setContentView
                (this,R.layout.activity_home_page);
        homePagePresenter=new HomePagePresenter(this);
        activityHomePageBinding.setHomePrisenter(homePagePresenter);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My Dictionary");

        setSupportActionBar(toolbar);

    }
    public void openSearChHistory(View view) {
        Intent intent = new Intent(this, SeachHistoryActivity.class);
        startActivity(intent);

    }

    @Override
    public void openSearch() {
        Intent intent = new Intent(this, ChoseSearchActivity.class);
        startActivity(intent);
    }

    @Override
    public void openFavorite() {
        Intent intent = new Intent(this, ListFavoriteActivity.class);
        startActivity(intent);
    }
}
