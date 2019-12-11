package com.example.mydictionary.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mydictionary.R;
import com.example.mydictionary.adapter.HistoryAadpter;
import com.example.mydictionary.dao.HistoryDAO;
import com.example.mydictionary.inter.HistoryView;
import com.example.mydictionary.inter.SeachWordEngLishView;
import com.example.mydictionary.model.History;
import com.example.mydictionary.presenter.SearchEnglishPresenter;
import com.example.mydictionary.presenter.ShowHistoryPresenter;

import java.util.List;

public class ListHistoryActivity extends AppCompatActivity implements HistoryView {
    Toolbar toolbar5;
    private HistoryDAO historyDAO;
    private List<History> list;
    RecyclerView rvListHistory;
    private ShowHistoryPresenter showHistoryPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach_history);
        rvListHistory=findViewById(R.id.rvListHistory);
        toolbar5=findViewById(R.id.toolbar5);
        toolbar5.setTitle("Lịch sử tìm kiếm A - V");
        setSupportActionBar(toolbar5);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        historyDAO=new HistoryDAO(this);
        showHistoryPresenter=new ShowHistoryPresenter(this);
        showHistoryPresenter.show();
    }

    @Override
    public void showHistory() {
        list=historyDAO.getAllWordHistory();
        HistoryAadpter historyAadpter=new HistoryAadpter(this,list);
        rvListHistory.setAdapter(historyAadpter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvListHistory.setLayoutManager(linearLayoutManager);
        Log.e("abc",list.size()+"");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_eng_his,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.itHomePage){
            Intent intent=new Intent(this,HomePageActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.itVnHis){
            Intent intent=new Intent(this,ListHistoryVNActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
