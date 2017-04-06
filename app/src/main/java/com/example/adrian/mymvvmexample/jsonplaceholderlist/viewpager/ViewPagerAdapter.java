package com.example.adrian.mymvvmexample.jsonplaceholderlist.viewpager;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.databinding.ViewpagerItemLayoutBinding;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.rv.comment.RVCommentItemViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.rv.comment.RVCommentsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cadri on 2017. 03. 27..
 */

public class ViewPagerAdapter extends PagerAdapter {

    private static final String TAG = ViewPagerAdapter.class.getName();

    private Context context;

    private List<String> titleList;

    private LayoutInflater layoutInflater;

    private RVCommentsViewModel rvCommentsViewModel;



    public ObservableField<Integer> itemLayoutId;

    public ObservableList<RVCommentItemViewModel> itemViewModels = new ObservableArrayList<>();

    public ObservableField<Integer> variableId;

//    public ViewPagerAdapter(Context context, List<DataModel> itemViewModels, List<String> titleList) {
//        this.context = context;
//        this.itemViewModels = (List<T>) itemViewModels;
//        this.titleList = titleList;
//        layoutInflater = LayoutInflater.from(context);
//    }

    public ViewPagerAdapter(Context context, RVCommentsViewModel rvCommentsViewModel, List<String> titleList) {
        this.context = context;
        this.rvCommentsViewModel = rvCommentsViewModel;
//        this.itemViewModels = rvCommentsViewModel.getRvCommentItemViewModels();
//        this.itemViewModels.addAll(rvCommentsViewModel.getRvCommentItemViewModels());
        this.titleList = titleList;
        this.layoutInflater = LayoutInflater.from(context);

//        itemLayoutId.set(R.layout.rv_list_item_comment);
//        variableId.set(BR.viewModel);
//        this.itemViewModels.set(0, RVCommentsViewModel.getTestList().get(0));
//        this.itemViewModels.set(1, RVCommentsViewModel.getTestList().get(1));
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ViewpagerItemLayoutBinding binding = ViewpagerItemLayoutBinding.inflate(layoutInflater, collection, false);

//        RvListItemCommentBinding binding = RvListItemCommentBinding.inflate(layoutInflater, collection, false);

//        DataModel dataModel = itemViewModels.get(position);
//        binding.tvViewPagerText.setText(dataModel.getTitle());



        RVCommentItemViewModel model = itemViewModels.get(position);

//        variableId.set(rvCommentsViewModel.getVariableId());
//
//        itemLayoutId.set(rvCommentsViewModel.getCommentItemLayoutId());
//
//        itemViewModels.addAll(RVCommentsViewModel.getTestList());

        Log.i(TAG, model.toString());
//        binding.rvList.setAdapter();

        binding.setViewModel(rvCommentsViewModel);

        collection.addView(binding.getRoot());

        return binding.getRoot();
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return itemViewModels.size();
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
