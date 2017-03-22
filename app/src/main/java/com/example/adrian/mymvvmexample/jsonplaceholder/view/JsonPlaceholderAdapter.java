package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.databinding.ListItemJsonplaceholderBinding;
import com.example.adrian.mymvvmexample.jsonplaceholder.viewmodel.JsonPlaceholder;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/14/2017.
 */

public class JsonPlaceholderAdapter extends RecyclerView.Adapter<JsonPlaceholderAdapter.JsonPlaceholderHolder> {

    private static final String TAG = JsonPlaceholderAdapter.class.getName();

    List<JsonPlaceholder> list;

    public JsonPlaceholderAdapter(List<JsonPlaceholder> list) {
        this.list = list;
    }

    @Override
    public JsonPlaceholderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ListItemJsonplaceholderBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_jsonplaceholder, parent, false);

        return new JsonPlaceholderHolder(binding);
    }

    @Override
    public void onBindViewHolder(JsonPlaceholderHolder holder, int position) {
        JsonPlaceholder jsonPlaceholder = list.get(position);
        holder.bind(jsonPlaceholder);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class JsonPlaceholderHolder extends RecyclerView.ViewHolder {

        private final ListItemJsonplaceholderBinding binding;

        public JsonPlaceholderHolder(ListItemJsonplaceholderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(JsonPlaceholder jsonPlaceholder) {
            binding.setModel(jsonPlaceholder);
            binding.executePendingBindings();
        }
    }
}
