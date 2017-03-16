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

public class JsonPlaceholderApiAdapter extends RecyclerView.Adapter<JsonPlaceholderApiAdapter.JsonPlaceholderApiHolder> {

    private static final String TAG = JsonPlaceholderApiAdapter.class.getName();

    List<JsonPlaceholder> list;

    public JsonPlaceholderApiAdapter(List<JsonPlaceholder> list) {
        this.list = list;
    }

    @Override
    public JsonPlaceholderApiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ListItemJsonplaceholderBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_jsonplaceholder, parent, false);

        return new JsonPlaceholderApiHolder(binding);
    }

    @Override
    public void onBindViewHolder(JsonPlaceholderApiHolder holder, int position) {
        JsonPlaceholder jsonPlaceholder = list.get(position);
        holder.bind(jsonPlaceholder);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class JsonPlaceholderApiHolder extends RecyclerView.ViewHolder {

        private final ListItemJsonplaceholderBinding binding;

        public JsonPlaceholderApiHolder(ListItemJsonplaceholderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(JsonPlaceholder jsonPlaceholder) {
            binding.setModel(jsonPlaceholder);
            binding.executePendingBindings();
        }
    }
}
