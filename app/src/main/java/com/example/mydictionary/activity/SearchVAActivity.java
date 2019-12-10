package com.example.mydictionary.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mydictionary.R;
import com.example.mydictionary.adapter.VietNamAdapter;
import com.example.mydictionary.dao.VNHistoryDAO;
import com.example.mydictionary.dao.VietnameseDAO;
import com.example.mydictionary.databinding.ActivitySearchVaBinding;
import com.example.mydictionary.inter.SearchVietNamView;
import com.example.mydictionary.model.VNHistory;
import com.example.mydictionary.model.VietnameseWord;
import com.example.mydictionary.presenter.SeachVietNamPresenter;

import java.util.List;

public class SearchVAActivity extends AppCompatActivity implements SearchVietNamView {
    private Toolbar toolbar4;
    private VietnameseDAO vietnameseDAO;
    List<VietnameseWord> list;
    private EditText edtVNWord;
    private RecyclerView rvListVN;
    SeachVietNamPresenter seachVietNamPresenter;
    private List<VNHistory> vnHistoryList;
    private VNHistoryDAO vnHistoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchVaBinding activitySearchVaBinding = DataBindingUtil.setContentView
                (this, R.layout.activity_search_va);
        seachVietNamPresenter = new SeachVietNamPresenter(this);
        activitySearchVaBinding.setVNpresenter(seachVietNamPresenter);
        toolbar4 = findViewById(R.id.toolbar4);
        toolbar4.setTitle("Tìm kiếm V - A");
        setSupportActionBar(toolbar4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        edtVNWord = findViewById(R.id.edtVNWord);
        rvListVN = findViewById(R.id.rvListVA);
        vietnameseDAO = new VietnameseDAO(this);
        vnHistoryDAO = new VNHistoryDAO(this);

    }

    @Override
    public void seachVN() {
        String text = edtVNWord.getText().toString();
        vnHistoryList = vnHistoryDAO.getAllWordHistory();
        if (text.isEmpty()) {
            edtVNWord.setError("Mời bạn nhập từ!");
        } else {
            VNHistory history = new VNHistory();
            if (vnHistoryList.size() == 0) {
                history.setVnHistoryWord(text);
                vnHistoryDAO.insertVNHistory(history);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    history = vnHistoryList.get(i);
                    if (history.getVnHistoryWord().equalsIgnoreCase(text)) {

                    } else {
                        history.setVnHistoryWord(text);
                        vnHistoryDAO.insertVNHistory(history);
                    }
                }
            }
            list = vietnameseDAO.searchVNWord(text);
            if (list.size() == 0) {
                Toast.makeText(this, "Không có thông tin về từ", Toast.LENGTH_SHORT).show();
            } else {
                VietNamAdapter vietNamAdapter = new VietNamAdapter(this, list);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                rvListVN.setLayoutManager(linearLayoutManager);
                rvListVN.setAdapter(vietNamAdapter);
            }
        }
    }
}
