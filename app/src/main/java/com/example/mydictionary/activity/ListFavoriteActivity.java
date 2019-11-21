package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mydictionary.R;

public class ListFavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_favorite);
        setTitle("Danh sách yêu thích");
    }
}
