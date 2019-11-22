package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mydictionary.R;

public class HomePageActivity extends AppCompatActivity {
        private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("My Dictionary");
        setSupportActionBar(toolbar);

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
