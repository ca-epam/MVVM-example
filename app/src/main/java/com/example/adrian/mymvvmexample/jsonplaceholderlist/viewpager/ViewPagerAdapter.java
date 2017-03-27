package com.example.adrian.mymvvmexample.jsonplaceholderlist.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.databinding.ViewpagerItemLayoutBinding;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cadri on 2017. 03. 27..
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;

    private List<DataModel> itemList;

    private List<String> titleList;

    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, List<DataModel> itemList, List<String> titleList) {
        this.context = context;
        this.itemList = itemList;
        this.titleList = titleList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ViewpagerItemLayoutBinding binding = ViewpagerItemLayoutBinding.inflate(layoutInflater, collection, false);

        DataModel dataModel = itemList.get(position);
        binding.tvViewPagerText.setText(dataModel.getTitle());

        collection.addView(binding.getRoot());

        return binding.getRoot();
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
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
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }


    public List<String> testData() {
        List<String> list = new ArrayList<>();
        list.add("item - 1");
        list.add("item - 2");
        list.add("item - 4");
        list.add("item - 5");
        return list;
    }

}
