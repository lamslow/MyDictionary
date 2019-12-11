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

import com.example.mydictionary.R;
import com.example.mydictionary.adapter.VNHistoryAdapter;
import com.example.mydictionary.dao.VNHistoryDAO;
import com.example.mydictionary.databinding.ActivityListHistoryVnBinding;
import com.example.mydictionary.inter.HistoryVNView;
import com.example.mydictionary.model.VNHistory;
import com.example.mydictionary.presenter.ShowVNHistoryPresenter;

import java.util.List;

public class ListHistoryVNActivity extends AppCompatActivity implements HistoryVNView {
    private Toolbar toolbar9;
    private RecyclerView rvListHistoryVN;
    private VNHistoryDAO vnHistoryDAO;
    private List<VNHistory> vnHistoryList;
    private ActivityListHistoryVnBinding activityListHistoryVnBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityListHistoryVnBinding= DataBindingUtil.setContentView
                (this,R.layout.activity_list_history_vn);

        toolbar9 = (Toolbar) findViewById(R.id.toolbar9);
        toolbar9.setTitle("Lịch sử tìm kiếm V - A");
        setSupportActionBar(toolbar9);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvListHistoryVN = (RecyclerView) findViewById(R.id.rvListHistoryVN);
        vnHistoryDAO=new VNHistoryDAO(this);
        ShowVNHistoryPresenter showVNHistoryPresenter=new ShowVNHistoryPresenter(this);
        showVNHistoryPresenter.show();

    }

    @Override
    public void show() {
        vnHistoryList=vnHistoryDAO.getAllWordHistory();
        VNHistoryAdapter vnHistoryAdapter=new VNHistoryAdapter(this,vnHistoryList);
        rvListHistoryVN.setAdapter(vnHistoryAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvListHistoryVN.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vn_his,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.itHomePage){
            Intent intent=new Intent(this,HomePageActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.itEngHis){
            Intent intent=new Intent(this,ListHistoryActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
