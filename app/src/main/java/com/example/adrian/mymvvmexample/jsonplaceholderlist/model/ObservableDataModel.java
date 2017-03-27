package com.example.adrian.mymvvmexample.jsonplaceholderlist.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;

import java.util.List;

/**
 * Created by cadri on 2017. 03. 27..
 */

public class ObservableDataModel extends BaseObservable {

    private List<String> textList;

    public ObservableDataModel(List<String> textList) {
        this.textList = textList;
    }

    @Bindable
    public List<String> getTextList() {
        return textList;
    }

    public void setTextList(List<String> textList) {
        this.textList = textList;
        notifyPropertyChanged(BR.textList);
    }
}
