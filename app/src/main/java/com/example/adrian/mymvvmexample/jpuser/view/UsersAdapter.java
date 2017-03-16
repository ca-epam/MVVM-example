package com.example.adrian.mymvvmexample.jpuser.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.databinding.ListItemUserBinding;
import com.example.adrian.mymvvmexample.jpuser.viewmodel.UserViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiAdapter;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserHolder> {

    private static final String TAG = JsonPlaceholderApiAdapter.class.getName();

    List<UserViewModel> list;

    public UsersAdapter(List<UserViewModel> list) {
        this.list = list;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ListItemUserBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_user, parent, false);

        return new UserHolder(binding);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        UserViewModel userViewModel = list.get(position);
        holder.bind(userViewModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class UserHolder extends RecyclerView.ViewHolder {

        private final ListItemUserBinding binding;

        public UserHolder(ListItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UserViewModel userViewModel) {
            binding.setModel(userViewModel);
            binding.executePendingBindings();
        }
    }
}
