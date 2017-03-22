package com.example.adrian.mymvvmexample.jpalbum.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.jpalbum.view.AlbumItemAdapter;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Album;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class AlbumItemViewModel extends BaseObservable {

    private Album album;

    private AlbumItemAdapter albumItemAdapter;

    public AlbumItemViewModel(Album album) {
        this.album = album;
    }

    @Bindable
    public Integer getUserId() {
        return this.album.getUserId();
    }

    @Bindable
    public Integer getId() {
        return this.album.getId();
    }

    @Bindable
    public String getTitle() {
        return this.album.getTitle();
    }

    public void setUserId(Integer userId) {
        this.album.setUserId(userId);
        notifyPropertyChanged(BR.userId);
    }

    public void setId(Integer Id) {
        this.album.setId(Id);
        notifyPropertyChanged(BR.id);
    }

    public void setTitle(String title) {
        this.album.setTitle(title);
        notifyPropertyChanged(BR.title);
    }
}
