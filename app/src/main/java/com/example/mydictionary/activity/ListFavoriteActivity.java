package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.mydictionary.R;

public class ListFavoriteActivity extends AppCompatActivity {
    private Toolbar toolbar6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_favorite);
        toolbar6=findViewById(R.id.toolbar6);
        toolbar6.setTitle("Danh sách yêu thích");
        setSupportActionBar(toolbar6);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
