package com.example.adrian.mymvvmexample.jpalbum.viewmodel;

import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jpalbum.model.AlbumsModel;
import com.example.adrian.mymvvmexample.jpalbum.view.AlbumItemAdapter;
import com.example.adrian.mymvvmexample.jpalbum.view.AlbumsActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class AlbumsViewModel extends BaseViewModel<AlbumsActivity> implements AlbumsModel.OnAlbumCallback {

    private static final String TAG = AlbumsViewModel.class.getName();

    private AlbumsModel albumsModel;

    private AlbumItemAdapter albumItemAdapter;

    public AlbumsViewModel(AlbumsActivity albumsActivity, AlbumsModel albumsModel) {
        super(albumsActivity);
        this.albumsModel = albumsModel;

        getActivity().getBinding().rvAlbums.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        albumsModel.findAllAlbum();
    }

    @Override
    public void onStart() {
        super.onStart();
        albumsModel.registerCallback(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        albumsModel.unRegisterCallback();
    }

    private void setUpRecyclerView(List<AlbumItemViewModel> albumItemViewModels) {
        albumItemAdapter = new AlbumItemAdapter(albumItemViewModels);

        getActivity().getBinding().rvAlbums.setAdapter(albumItemAdapter);
    }

    private List<AlbumItemViewModel> convertToViewModel(List<Album> albums) {
        List<AlbumItemViewModel> albumItemViewModels = new ArrayList<>();
        for(Album a : albums) {
            albumItemViewModels.add(new AlbumItemViewModel(a));
        }
        return albumItemViewModels;
    }

    @Override
    public void onFindAllAlbumSuccess(List<Album> albums) {
        setUpRecyclerView(convertToViewModel(albums));
    }

    @Override
    public void onFindAllAlbumError(Throwable t) {

        t.printStackTrace();
    }
}