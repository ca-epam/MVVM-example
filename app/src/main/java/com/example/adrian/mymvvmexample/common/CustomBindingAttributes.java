package com.example.adrian.mymvvmexample.common;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.databinding.library.baseAdapters.BR;
import com.example.adrian.mymvvmexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/23/2017.
 */

public final class CustomBindingAttributes {

    private CustomBindingAttributes() {
    }

    @BindingAdapter("app:sg")
    public static void sgTextView(TextView textView, String s) {
        textView.setText(s);
    }

//    @BindingAdapter("app:adapter")
//    public static void setRecyclerViewAdapter(RecyclerView recyclerView, List<ListItemViewModel> items) {
////        getAdapter(recyclerView).set
////                recyclerView.setad
//
//    }

    @BindingAdapter("app:adapter")
    public static void setupRecyclerViewAdapter(RecyclerView recyclerView, String str) {
        SampleListItemViewModel sampleListItemViewModel1 = new SampleListItemViewModel(1,"title1");
        SampleListItemViewModel sampleListItemViewModel2 = new SampleListItemViewModel(2,"title2");
        List<SampleListItemViewModel> list = new ArrayList<>();
        list.add(sampleListItemViewModel1);
        list.add(sampleListItemViewModel2);
        RecyclerViewAdapter2 recyclerViewAdapter2 = new RecyclerViewAdapter2(list, R.layout.list_item_sample, BR.sampleItemVM);
        recyclerView.setAdapter(recyclerViewAdapter2);
        str.toString();
    }


//    @BindingAdapter("app:layout")
//    public static void setRecyclerViewLayout() {
//
//    }

    private static RecyclerViewAdapter getAdapter(RecyclerView recyclerView) {
        RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new RecyclerViewAdapter();
            recyclerView.setAdapter(adapter);
        }
        return adapter;
    }

}
