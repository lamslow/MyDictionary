package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.DetailWordView;

public class AddFavoritePresenter {
    private DetailWordView detailWordView;

    public AddFavoritePresenter(DetailWordView detailWordView) {
        this.detailWordView = detailWordView;
    }
    public void add(){
        detailWordView.addFavorite();
    }
    public void show(){detailWordView.show();}
}
