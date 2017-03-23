package com.example.adrian.mymvvmexample.common;

import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.jppost.viewmodel.ListItemViewModel;

/**
 * Created by Adrian_Czigany on 3/23/2017.
 */

public class SampleListItemViewModel extends ListItemViewModel {

    private int id;
    private String title;

    public SampleListItemViewModel(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
}
