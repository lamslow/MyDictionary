package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.HomePageView;

public class HomePagePresenter {
    private HomePageView homePageView;

    public HomePagePresenter(HomePageView homePageView) {
        this.homePageView = homePageView;
    }

    public void openSearch() {
        homePageView.openSearch();
    }
    public void openFavorite() {
        homePageView.openFavorite();
    }
}
