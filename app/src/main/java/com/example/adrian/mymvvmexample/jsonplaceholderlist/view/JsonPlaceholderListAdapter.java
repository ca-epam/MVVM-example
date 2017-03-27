package com.example.adrian.mymvvmexample.jsonplaceholderlist.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.DataModel;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/27/2017.
 */

public class JsonPlaceholderListAdapter extends PagerAdapter {

    private Context context;

    private List<DataModel> itemList;

    private List<String> titleList;

    private LayoutInflater layoutInflater;

    public JsonPlaceholderListAdapter(Context context, List<DataModel> itemList, List<String> titleList) {
        this.context = context;
        this.itemList = itemList;
        this.titleList = titleList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
