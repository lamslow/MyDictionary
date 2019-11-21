package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mydictionary.R;
import com.example.mydictionary.activity.SearchAVActivity;
import com.example.mydictionary.activity.SearchVAActivity;

public class ChoseSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_search);
    }

    public void openSearchVA(View view) {

        Intent intent = new Intent(this, SearchVAActivity.class);
        startActivity(intent);
    }

    public void openSearchAV(View view) {
        Intent intent = new Intent(this, SearchAVActivity.class);
        startActivity(intent);
    }
}
