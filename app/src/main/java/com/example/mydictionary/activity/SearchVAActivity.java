package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mydictionary.R;

public class SearchVAActivity extends AppCompatActivity {
    private Toolbar toolbar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_va);
        toolbar4=findViewById(R.id.toolbar4);
        toolbar4.setTitle("Tìm kiếm V - A");
        setSupportActionBar(toolbar4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}
