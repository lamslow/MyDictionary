package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.VNFavoriteView;

public class VNFavoritePresenter {
    VNFavoriteView vnFavoriteView;

    public VNFavoritePresenter(VNFavoriteView vnFavoriteView) {
        this.vnFavoriteView = vnFavoriteView;
    }
    public void show(){
        vnFavoriteView.show();
    }
}
