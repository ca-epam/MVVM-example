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

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.BindingViewHolder> {

    private List<? extends ListItemViewModel> items;

    private int itemLayout;

    private int variableId;

    public RecyclerViewAdapter2(List<? extends ListItemViewModel> items, int itemLayout, int variableId) {
        this.items = items;
        this.itemLayout = itemLayout;
        this.variableId = variableId;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        int itemLayout = itemLayouts.get(viewTypes != null ? viewTypes.indexOf(viewType) : viewType);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), itemLayout, parent, false);

        return new BindingViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
//        holder.getBinding().setVariable(BR.viewModel, items.get(position));
//        holder.getBinding().executePendingBindings();
        ListItemViewModel itemViewModel = items.get(position);
        holder.bind(itemViewModel, variableId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<ListItemViewModel> items) {
        this.items = items;
        notifyDataSetChanged();
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
