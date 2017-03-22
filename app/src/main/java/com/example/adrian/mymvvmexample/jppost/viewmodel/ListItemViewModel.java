package com.example.adrian.mymvvmexample.jppost.viewmodel;

import android.databinding.BaseObservable;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public abstract class ListItemViewModel extends BaseObservable {
    public abstract int getViewType();
}
