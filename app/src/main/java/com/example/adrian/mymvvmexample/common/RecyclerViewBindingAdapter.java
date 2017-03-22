package com.example.adrian.mymvvmexample.common;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.adrian.mymvvmexample.jppost.viewmodel.ListItemViewModel;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class RecyclerViewBindingAdapter {

    private RecyclerViewBindingAdapter() {
    }

    @BindingAdapter("source")
    public static void setupRecyclerViewSource(RecyclerView recyclerView, List<ListItemViewModel> source) {
        getAdapter(recyclerView).setItems(source);
    }

    @BindingAdapter("itemLayout")
    public static void setupRecyclerViewItemLayout(RecyclerView recyclerView, int itemLayout) {
        getAdapter(recyclerView).setItemLayout(itemLayout);
    }

    private static RecyclerViewAdapter getAdapter(RecyclerView recyclerView) {
        RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new RecyclerViewAdapter();
            recyclerView.setAdapter(adapter);
        }
        return adapter;
    }
}
