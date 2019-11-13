package com.example.mydictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SearchVAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_va);
        setTitle("Tìm kiếm V-A");
    }

    public void openDetailWord(View view) {
        Intent intent=new Intent(this,DetailWordActivity.class);
        startActivity(intent);
    }
}
