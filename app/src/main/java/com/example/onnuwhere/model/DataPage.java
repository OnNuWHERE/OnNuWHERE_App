package com.example.onnuwhere.model;


import java.util.List;

public class DataPage {
    List<Recycle> recycleList;

    public DataPage(){

    }
    public DataPage(List<Recycle> recycleList) {
        this.recycleList = recycleList;
    }

    public List<Recycle> getRecycleList() {
        return recycleList;
    }

    public void setRecycleList(List<Recycle> recycleList) {
        this.recycleList = recycleList;
    }
}
