package com.example.mydictionary.presenter;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mydictionary.adapter.EnglishAdapter;
import com.example.mydictionary.dao.EnglishDAO;
import com.example.mydictionary.inter.SeachWordEngLishView;
import com.example.mydictionary.model.Word;

import java.util.List;

public class SearchEnglishPresenter {
    private SeachWordEngLishView seachWordEngLishView;


    public SearchEnglishPresenter(SeachWordEngLishView seachWordEngLishView) {
        this.seachWordEngLishView = seachWordEngLishView;
    }
    public void search(){
        seachWordEngLishView.seachEnglish();
    }

}
