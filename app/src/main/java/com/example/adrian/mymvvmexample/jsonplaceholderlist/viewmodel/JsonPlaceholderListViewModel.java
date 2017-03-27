package com.example.adrian.mymvvmexample.jsonplaceholderlist.viewmodel;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.view.JsonPlaceholderListActivity;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.JsonPlaceholderListModel;

/**
 * Created by Adrian_Czigany on 3/27/2017.
 */

public class JsonPlaceholderListViewModel extends BaseViewModel<JsonPlaceholderListActivity> {

    private JsonPlaceholderListModel jsonPlaceholderListModel;

    public JsonPlaceholderListViewModel(JsonPlaceholderListActivity jsonPlaceholderListActivity, JsonPlaceholderListModel jsonPlaceholderListModel) {
        super(jsonPlaceholderListActivity);
        this.jsonPlaceholderListModel = jsonPlaceholderListModel;
    }

}
