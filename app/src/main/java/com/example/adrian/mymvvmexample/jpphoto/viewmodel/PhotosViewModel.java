package com.example.adrian.mymvvmexample.jpphoto.viewmodel;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jpphoto.model.PhotosModel;
import com.example.adrian.mymvvmexample.jpphoto.view.PhotosActivity;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class PhotosViewModel extends BaseViewModel<PhotosActivity> {

    private PhotosModel photosModel;

    public PhotosViewModel(PhotosActivity activity, PhotosModel photosModel) {
        super(activity);
        this.photosModel = photosModel;
    }

}
