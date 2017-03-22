package com.example.adrian.mymvvmexample.jpcomment.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.databinding.ListItemCommentBinding;
import com.example.adrian.mymvvmexample.jpcomment.viewmodel.CommentItemViewModel;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class CommentItemAdapter extends RecyclerView.Adapter<CommentItemAdapter.CommentItemHolder> {

    private List<CommentItemViewModel> list;

    public CommentItemAdapter(List<CommentItemViewModel> list) {
        this.list = list;
    }

    @Override
    public CommentItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemCommentBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_comment, parent, false);
        return new CommentItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(CommentItemHolder holder, int position) {
        CommentItemViewModel item = list.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CommentItemHolder extends RecyclerView.ViewHolder {

        private ListItemCommentBinding  binding;

        public CommentItemHolder(ListItemCommentBinding  binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CommentItemViewModel commentItemViewModel) {
            binding.setCommentItemVM(commentItemViewModel);
            binding.executePendingBindings();
        }


    }
}
