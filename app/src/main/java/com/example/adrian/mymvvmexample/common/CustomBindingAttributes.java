package com.example.adrian.mymvvmexample.common;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.adrian.mymvvmexample.jppost.viewmodel.ListItemViewModel;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/23/2017.
 */

public final class CustomBindingAttributes {

    private CustomBindingAttributes() {
    }

//    @BindingAdapter("app:sg")
//    public static void sgTextView(TextView textView, String s) {
//        textView.setText(s);
//    }

//    @BindingAdapter("app:adapter")
//    public static void setRecyclerViewAdapter(RecyclerView recyclerView, List<ListItemViewModel> items) {
////        getAdapter(recyclerView).set
////                recyclerView.setad
//
//    }

//    @BindingAdapter({"app:adapter", "app:layout"})
//    public static void setupRecyclerViewAdapter(RecyclerView recyclerView, String str, int itemLayout) {
//        SampleListItemViewModel sampleListItemViewModel1 = new SampleListItemViewModel(1,"title1");
//        SampleListItemViewModel sampleListItemViewModel2 = new SampleListItemViewModel(2,"title2");
//        List<SampleListItemViewModel> list = new ArrayList<>();
//        list.add(sampleListItemViewModel1);
//        list.add(sampleListItemViewModel2);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(list, itemLayout, BR.sampleItemVM);
//        recyclerView.setAdapter(recyclerViewAdapter);
//        str.toString();
//    }

//    @BindingAdapter("items")
//    public static void setupRecyclerViewAdapter(RecyclerView recyclerView, List<? extends ListItemViewModel> items) {
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(items, R.layout.list_item_post, BR.postItemVM);
//        recyclerView.setAdapter(recyclerViewAdapter);
//    }

//    @BindingAdapter({"items", "itemLayout"})
//    public static void setupRecyclerViewAdapter(RecyclerView recyclerView, List<? extends ListItemViewModel> items, int itemLayout) {
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(items, itemLayout, BR.postItemVM);
//        recyclerView.setAdapter(recyclerViewAdapter);
//    }

    @BindingAdapter(value = {"listItems", "listItemLayout", "variableId"}, requireAll = true)
    public static void setupRecyclerViewAdapter(RecyclerView recyclerView, List<? extends ListItemViewModel> items, int itemLayout, int variableId) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(items, itemLayout, variableId);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

//    @BindingAdapter({"app:items", "app:itemLayout"})
//    public static void setupRecyclerViewAdapter(RecyclerView recyclerView, List<? extends ListItemViewModel> items, int itemLayout) {
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(items, itemLayout, BR.postItemVM);
//        recyclerView.setAdapter(recyclerViewAdapter);
//    }


//    @BindingAdapter("app:layout")
//    public static void setRecyclerViewLayout() {
//
//    }

    private static RecyclerViewAdapter3 getAdapter(RecyclerView recyclerView) {
        RecyclerViewAdapter3 adapter = (RecyclerViewAdapter3) recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new RecyclerViewAdapter3();
            recyclerView.setAdapter(adapter);
        }
        return adapter;
    }

}
