package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydictionary.R;
import com.example.mydictionary.dao.EnglishDAO;
import com.example.mydictionary.model.Word;

import java.util.List;

public class DetailWordActivity extends AppCompatActivity {
    private EnglishDAO englishDAO;
    private TextView tvword,tvDes,tvPro;
    ImageView imgFav;
    Toolbar toolbar7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_word);
        toolbar7=findViewById(R.id.toolbar7);
        toolbar7.setTitle("My Dictionary");
        setSupportActionBar(toolbar7);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvword=findViewById(R.id.tvWord);
        tvDes=findViewById(R.id.tvDes);
        tvPro=findViewById(R.id.tvPro);
        imgFav=findViewById(R.id.imgFav);
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
        int id =R.drawable.star;
        imgFav.setImageResource(id);
        Toast.makeText(this, "Bạn đã thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
    }
}
