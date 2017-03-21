package com.example.adrian.mymvvmexample.jppost.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.databinding.ListItemPostBinding;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostItemViewModel;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/21/2017.
 */

public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.PostItemHolder> {

    private static final String TAG = PostItemAdapter.class.getName();

    private List<PostItemViewModel> list;

    public PostItemAdapter(List<PostItemViewModel> list) {
        this.list = list;
    }

    @Override
    public PostItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemPostBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_post, parent, false);
        return new PostItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(PostItemHolder holder, int position) {
        PostItemViewModel item = list.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PostItemHolder extends RecyclerView.ViewHolder {

        private ListItemPostBinding binding;

        public PostItemHolder(ListItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PostItemViewModel postItemViewModel) {
            binding.setPostItemVM(postItemViewModel);
            binding.executePendingBindings();
        }
    }
}
