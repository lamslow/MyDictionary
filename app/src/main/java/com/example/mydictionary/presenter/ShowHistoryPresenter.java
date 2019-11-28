package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.HistoryView;

public class ShowHistoryPresenter {
    private HistoryView historyView;

    public ShowHistoryPresenter(HistoryView historyView) {
        this.historyView = historyView;
    }
    public void show(){
        historyView.showHistory();
    }
}
