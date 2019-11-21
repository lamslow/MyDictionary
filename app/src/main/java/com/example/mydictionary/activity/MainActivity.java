package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.mydictionary.R;
import com.example.mydictionary.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        databaseHelper.createDataBase();
        CountDownTimer countDownTimer=new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent=new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}
