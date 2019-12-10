package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.DetailWordVNView;

public class ShowDetailVNPresenter {
    DetailWordVNView detailWordVNView;

    public ShowDetailVNPresenter(DetailWordVNView detailWordVNView) {
        this.detailWordVNView = detailWordVNView;
    }
    public void show(){
        detailWordVNView.showDetailVN();
    }
    public void add(){
        detailWordVNView.addFav();
    }
}
