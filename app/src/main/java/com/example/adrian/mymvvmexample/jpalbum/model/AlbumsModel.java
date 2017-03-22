package com.example.adrian.mymvvmexample.jpalbum.model;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Album;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.AlbumService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class AlbumsModel  {

    private static final String TAG = AlbumsModel.class.getName();

    private final AlbumService albumService;

    private Observer<List<Album>> albumListObserver;

    private Observer<Album> albumObserver;

    private OnAlbumCallback callback;

    public AlbumsModel(AlbumService albumService) {
        this.albumService = albumService;

        createAlbumListObserver();
        createAlbumObserver();

    }

    private void createAlbumListObserver() {
        albumListObserver = new Observer<List<Album>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllAlbumError(e);
            }

            @Override
            public void onNext(List<Album> albums) {
                Log.i(TAG, "onNext");
                Log.i(TAG, albums.toString());
                callback.onFindAllAlbumSuccess(albums);
            }
        };
    }

    private void createAlbumObserver() {
        albumObserver = new Observer<Album>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(Album album) {
                Log.i(TAG, "onNext");
                Log.i(TAG, album.toString());
            }
        };
    }

    public void findAllAlbum() {
        albumService.findAllAlbum()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(albumListObserver);
    }

    public void registerCallback(OnAlbumCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnAlbumCallback {

        void onFindAllAlbumSuccess(List<Album> albums);

        void onFindAllAlbumError(Throwable t);

    }

}
