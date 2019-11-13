package com.example.mydictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void openChose(View view) {
        Intent intent = new Intent(this, ChoseSearchActivity.class);
        startActivity(intent);
    }

    public void openListFavorite(View view) {
        Intent intent = new Intent(this, ListFavoriteActivity.class);
        startActivity(intent);
    }

    public void openSearChHistory(View view) {
        Intent intent = new Intent(this, SeachHistoryActivity.class);
        startActivity(intent);


    }
}
