package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mydictionary.R;
import com.example.mydictionary.activity.SearchAVActivity;
import com.example.mydictionary.activity.SearchVAActivity;
import com.example.mydictionary.databinding.ActivityChoseSearchBinding;
import com.example.mydictionary.inter.ChoseSearchView;
import com.example.mydictionary.presenter.ChooseSearchPresenter;

public class ChoseSearchActivity extends AppCompatActivity implements ChoseSearchView {
    private Toolbar toolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChoseSearchBinding activityChoseSearchBinding= DataBindingUtil.setContentView(
                this,R.layout.activity_chose_search);
        ChooseSearchPresenter chooseSearchPresenter=new ChooseSearchPresenter(this);
        activityChoseSearchBinding.setChoosePresenter(chooseSearchPresenter);
        toolbar2 = findViewById(R.id.toolbar2);

        toolbar2.setTitle("My Dictionary");
        setSupportActionBar(toolbar2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public void chooseVA() {
        Intent intent = new Intent(this, SearchVAActivity.class);
        startActivity(intent);
    }

    @Override
    public void chooseAV() {
        Intent intent = new Intent(this, SearchAVActivity.class);
        startActivity(intent);
    }
}
