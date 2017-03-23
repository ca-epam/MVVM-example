package com.example.adrian.mymvvmexample.jpphoto.viewmodel;

import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.common.ListItemViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Photo;

/**
 * Created by Adrian_Czigany on 3/21/2017.
 */

public class PhotoItemViewModel extends ListItemViewModel {

    private Photo photo;

    public PhotoItemViewModel(Photo photo) {
        this.photo = photo;
    }

    @Bindable
    public Integer getAlbumId() {
        return this.photo.getAlbumId();
    }

    @Bindable
    public Integer getId() {
        return this.photo.getId();
    }

    @Bindable
    public String getTitle() {
        return this.photo.getTitle();
    }

    @Bindable
    public String getUrl() {
        return this.photo.getUrl();
    }

    @Bindable
    public String getThumbnailUrl() {
        return this.photo.getThumbnailUrl();
    }

    public void setAlbumId(final int albumId) {
        this.photo.setAlbumId(albumId);
        notifyPropertyChanged(BR.albumId);
    }

    public void setId(final int id) {
        this.photo.setId(id);
        notifyPropertyChanged(BR.id);
    }

    public void setTitle(final String title) {
        this.photo.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    public void setUrl(final String url) {
        this.photo.setUrl(url);
        notifyPropertyChanged(BR.url);
    }

    public void setThumbnailUrl(final String thumbnailUrl) {
        this.photo.setThumbnailUrl(thumbnailUrl);
        notifyPropertyChanged(BR.thumbnailUrl);
    }

    @Override
    public String toString() {
        return "PhotoItemViewModel{" +
                "post=" + this.photo +
                '}';
    }

}
