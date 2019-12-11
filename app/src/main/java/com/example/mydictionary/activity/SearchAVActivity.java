package com.example.mydictionary.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mydictionary.R;
import com.example.mydictionary.adapter.EnglishAdapter;
import com.example.mydictionary.dao.EnglishDAO;
import com.example.mydictionary.dao.HistoryDAO;
import com.example.mydictionary.databinding.ActivityHomePageBinding;
import com.example.mydictionary.databinding.ActivitySearchAvBinding;
import com.example.mydictionary.inter.SeachWordEngLishView;
import com.example.mydictionary.model.History;
import com.example.mydictionary.model.VNHistory;
import com.example.mydictionary.model.Word;
import com.example.mydictionary.presenter.HomePagePresenter;
import com.example.mydictionary.presenter.SearchEnglishPresenter;

import java.util.List;

public class SearchAVActivity extends AppCompatActivity implements SeachWordEngLishView {
    private EditText edtWordAV;
    private RecyclerView rvListAV;
    private EnglishDAO englishDAO;
    private HistoryDAO historyDAO;
    private List<Word> wordList;
    private List<History> historyList;
    private Toolbar toolbar3;
    private SearchEnglishPresenter searchEnglishPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchAvBinding activitySearchAvBinding = DataBindingUtil.setContentView
                (this, R.layout.activity_search_av);
        searchEnglishPresenter = new SearchEnglishPresenter(this);
        activitySearchAvBinding.setEnglishPrisenter(searchEnglishPresenter);
        toolbar3 = findViewById(R.id.toolbar3);
        edtWordAV = findViewById(R.id.edtWordAV);
        toolbar3.setTitle("Tìm kiếm A - V");
        setSupportActionBar(toolbar3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvListAV = findViewById(R.id.rvListAV);
        englishDAO = new EnglishDAO(this);
        historyDAO = new HistoryDAO(this);
        searchEnglishPresenter.receiveData();
        searchEnglishPresenter.search();


    }

    @Override
    public void seachEnglish() {

        String text = edtWordAV.getText().toString().trim();
        historyList = historyDAO.getAllWordHistory();
        if (text.isEmpty()) {
            edtWordAV.setError("Mời bạn nhập từ!");
        } else {

            History history = new History();
            if (historyList.size() == 0) {
                history.setWordHistory(text);
                historyDAO.insertHistory(history);
            } else {
                for (int i = 0; i < historyList.size(); i++) {
                    history = historyList.get(i);
                    if (history.getWordHistory().equalsIgnoreCase(text)) {

                    } else {
                        history.setWordHistory(text);
                        historyDAO.insertHistory(history);

                    }
                }
            }

            wordList = englishDAO.searchWord(text);
            if (wordList.size() == 0) {
                Toast.makeText(this, "Không có thông tin về từ", Toast.LENGTH_SHORT).show();
            } else {
                EnglishAdapter englishAdapter = new EnglishAdapter(this, wordList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                rvListAV.setLayoutManager(linearLayoutManager);
                rvListAV.setAdapter(englishAdapter);
            }

        }


    }

    @Override
    public void receiveData() {
        Intent intent = getIntent();
        String dataHis = intent.getStringExtra("dataHis");
        edtWordAV.setText(dataHis);

    }


}
