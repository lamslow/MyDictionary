package com.example.mydictionary.presenter;

import com.example.mydictionary.inter.SearchVietNamView;

public class SeachVietNamPresenter {
    SearchVietNamView searchVietNamView;

    public SeachVietNamPresenter(SearchVietNamView searchVietNamView) {
        this.searchVietNamView = searchVietNamView;
    }
    public void seachVN(){
        searchVietNamView.seachVN();
    }
    public void receive(){searchVietNamView.receiveData();}
}
