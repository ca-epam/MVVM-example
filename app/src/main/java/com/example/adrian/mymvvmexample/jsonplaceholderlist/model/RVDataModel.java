package com.example.adrian.mymvvmexample.jsonplaceholderlist.model;

import com.example.adrian.mymvvmexample.jsonplaceholderlist.rv.comment.RVCommentsViewModel;

/**
 * Created by Adrian_Czigany on 3/27/2017.
 */

public class RVDataModel {

    private RVCommentsViewModel rvCommentsViewModel;

    public RVDataModel(RVCommentsViewModel rvCommentsViewModel) {
        this.rvCommentsViewModel = rvCommentsViewModel;
    }

    public RVCommentsViewModel getRvCommentsViewModel() {
        return rvCommentsViewModel;
    }

    public void setRvCommentsViewModel(RVCommentsViewModel rvCommentsViewModel) {
        this.rvCommentsViewModel = rvCommentsViewModel;
    }
}
