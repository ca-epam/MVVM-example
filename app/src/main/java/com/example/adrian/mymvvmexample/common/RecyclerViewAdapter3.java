package com.example.adrian.mymvvmexample.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerViewAdapter3.BindingViewHolder> {

    private int column;

    private boolean displayFullRows;

    private List<ListItemViewModel> items;

    private List<Integer> itemLayouts;

    private List<Integer> viewTypes;

    public RecyclerViewAdapter3() {
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int itemLayout = itemLayouts.get(viewTypes != null ? viewTypes.indexOf(viewType) : viewType);
        ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), itemLayout, parent, false);
        return new BindingViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
//        holder.getBinding().setVariable(BR.viewModel, items.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        int itemCount = items == null ? 0 : items.size();
        if (itemCount > column && displayFullRows) {
            itemCount = getRoundDownItemCount(itemCount);
        }
        return itemCount;
    }

    public void setItems(List<ListItemViewModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setItemLayout(int itemLayout) {
        this.itemLayouts = Collections.singletonList(itemLayout);
    }

    public void setItemLayouts(List<Integer> itemLayouts) {
        this.itemLayouts = itemLayouts;
    }

    public void setViewTypes(List<Integer> viewTypes) {
        this.viewTypes = viewTypes;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void displayFullRows(boolean displayFullRows) {
        this.displayFullRows = displayFullRows;
    }

    private int getRoundDownItemCount(int itemCount) {
        return itemCount - itemCount % column;
    }

    static class BindingViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;
        public BindingViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

}