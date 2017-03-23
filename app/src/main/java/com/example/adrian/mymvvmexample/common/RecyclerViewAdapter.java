package com.example.adrian.mymvvmexample.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.jppost.viewmodel.ListItemViewModel;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.BindingViewHolder> {

    private List<? extends ListItemViewModel> items;

    private int itemLayout;

    private int variableId;

    public RecyclerViewAdapter(List<? extends ListItemViewModel> items, int itemLayout, int variableId) {
        this.items = items;
        this.itemLayout = itemLayout;
        this.variableId = variableId;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding dataBinding = DataBindingUtil.inflate(layoutInflater, itemLayout, parent, false);
        return new BindingViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        ListItemViewModel itemViewModel = items.get(position);
        holder.bind(itemViewModel, variableId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class BindingViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;
        public BindingViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ListItemViewModel listItemViewModel, int variableId) {
            binding.setVariable(variableId, listItemViewModel);
            binding.executePendingBindings();
        }
    }

}
