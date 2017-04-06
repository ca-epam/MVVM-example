package com.example.adrian.mymvvmexample.jsonplaceholderlist.viewpager;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.rv.comment.RVCommentItemViewModel;

import java.util.List;

/**
 * Created by Adrian_Czigany on 4/6/2017.
 */

public class ViewPagerViewModel extends BaseObservable {

    public List<RVCommentItemViewModel> itemViewModels;

    public int itemLayoutId = R.layout.rv_list_item_comment;

    public int variableId = BR.rvCommentItemVM;

    @Bindable
    public List<RVCommentItemViewModel> getItemViewModels() {
        return itemViewModels;
    }

    public void setItemViewModels(List<RVCommentItemViewModel> itemViewModels) {
        itemViewModels = itemViewModels;
        notifyPropertyChanged(BR.itemViewModels);
    }

    @Bindable
    public int getItemLayoutId() {
        return itemLayoutId;
    }

    public void setItemLayoutId(int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
        notifyPropertyChanged(BR.itemLayoutId);
    }

    @Bindable
    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
        notifyPropertyChanged(BR.variableId);
    }
}

