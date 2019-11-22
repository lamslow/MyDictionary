package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.mydictionary.R;

public class SeachHistoryActivity extends AppCompatActivity {
    Toolbar toolbar5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach_history);
        toolbar5=findViewById(R.id.toolbar5);
        toolbar5.setTitle("Lịch sử tìm kiếm");
        setSupportActionBar(toolbar5);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
