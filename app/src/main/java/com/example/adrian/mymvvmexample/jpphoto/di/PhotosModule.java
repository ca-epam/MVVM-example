package com.example.adrian.mymvvmexample.jpphoto.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpphoto.model.PhotosModel;
import com.example.adrian.mymvvmexample.jpphoto.view.PhotosActivity;
import com.example.adrian.mymvvmexample.jpphoto.viewmodel.PhotosViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

@Module
public class PhotosModule {

    private PhotosActivity photosActivity;

    public PhotosModule(PhotosActivity photosActivity) {
        this.photosActivity = photosActivity;
    }

    @ActivityScope
    @Provides
    PhotosActivity providesPhotosActivity() {
        return this.photosActivity;
    }

    @ActivityScope
    @Provides
    PhotosModel providesPhotosModel() {
        return new PhotosModel();
    }

    @ActivityScope
    @Provides
    PhotosViewModel providesPhotosViewModel(PhotosActivity photosActivity, PhotosModel photosModel) {
        return new PhotosViewModel(photosActivity, photosModel);
    }
}

