package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mydictionary.R;
import com.example.mydictionary.dao.EnglishDAO;
import com.example.mydictionary.model.Word;

import java.util.List;

public class DetailWordActivity extends AppCompatActivity {
    private EnglishDAO englishDAO;
    private TextView tvword,tvDes,tvPro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_word);
        tvword=findViewById(R.id.tvWord);
        tvDes=findViewById(R.id.tvDes);
        tvPro=findViewById(R.id.tvPro);
        englishDAO=new EnglishDAO(this);
        Intent intent=getIntent();
        String data=intent.getStringExtra("data");
        Log.e("abc",data+"");
        Word word= englishDAO.searchWordByName(data);
        tvword.setText(word.word);
        tvPro.setText("/"+ word.pronounce+"/");
        tvDes.setText(word.description);
    }

    public void addFavorite(View view) {
    }
}
