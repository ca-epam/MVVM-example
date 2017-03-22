package com.example.adrian.mymvvmexample.jpalbum.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.databinding.ListItemAlbumBinding;
import com.example.adrian.mymvvmexample.jpalbum.viewmodel.AlbumItemViewModel;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class AlbumItemAdapter extends RecyclerView.Adapter<AlbumItemAdapter.AlbumItemHolder> {

    private List<AlbumItemViewModel> list;

    public AlbumItemAdapter(List<AlbumItemViewModel> list) {
        this.list = list;
    }

    @Override
    public AlbumItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemAlbumBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_album, parent, false);
        return new AlbumItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(AlbumItemHolder holder, int position) {
        AlbumItemViewModel albumItemViewModel = list.get(position);
        holder.bind(albumItemViewModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class AlbumItemHolder extends RecyclerView.ViewHolder {

        private ListItemAlbumBinding binding;

        public AlbumItemHolder(ListItemAlbumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(AlbumItemViewModel albumItemViewModel) {
            binding.setAlbumItemVM(albumItemViewModel);
            binding.executePendingBindings();
        }


    }
}
