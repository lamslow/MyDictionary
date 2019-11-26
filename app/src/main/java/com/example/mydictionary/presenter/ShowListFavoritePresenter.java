package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.ListFavoriteView;

public class ShowListFavoritePresenter {
    private ListFavoriteView listFavoriteView;

    public ShowListFavoritePresenter(ListFavoriteView listFavoriteView) {
        this.listFavoriteView = listFavoriteView;
    }
    public void ShowListFavorite(){
        listFavoriteView.showListFav();
    }
}
