package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mydictionary.R;
import com.example.mydictionary.adapter.EnglishAdapter;
import com.example.mydictionary.dao.EnglishDAO;
import com.example.mydictionary.model.Word;

import java.util.List;

public class SearchAVActivity extends AppCompatActivity {
    private EditText edtWordAV;
    private RecyclerView rvListAV;
    private EnglishDAO englishDAO;
    private List<Word> wordList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_av);
        setTitle("Tìm kiếm A-V");
        edtWordAV=findViewById(R.id.edtWordAV);
        rvListAV =findViewById(R.id.rvListAV);
        englishDAO=new EnglishDAO(this);
    }

    public void searchEngLish(View view) {
        String text=edtWordAV.getText().toString().trim();
        wordList= englishDAO.searchWord(text);
        EnglishAdapter englishAdapter=new EnglishAdapter(this,wordList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvListAV.setLayoutManager(linearLayoutManager);
        rvListAV.setAdapter(englishAdapter);
    }
}
