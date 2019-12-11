package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.HistoryVNView;

public class ShowVNHistoryPresenter {
    HistoryVNView historyVNView;

    public ShowVNHistoryPresenter(HistoryVNView historyVNView) {
        this.historyVNView = historyVNView;
    }
    public void show(){
        historyVNView.show();
    }
}
