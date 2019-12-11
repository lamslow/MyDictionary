package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.ChoseSearchView;

public class ChooseSearchPresenter {
    ChoseSearchView choseSearchView;

    public ChooseSearchPresenter(ChoseSearchView choseSearchView) {
        this.choseSearchView = choseSearchView;
    }
    public void chooseVA(){
        choseSearchView.chooseVA();
    }
    public void chooseAV(){
        choseSearchView.chooseAV();
    }
}
