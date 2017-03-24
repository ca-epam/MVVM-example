package com.example.adrian.mymvvmexample.jpphoto.view;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityPhotosBinding;
import com.example.adrian.mymvvmexample.jpphoto.di.PhotosComponent;
import com.example.adrian.mymvvmexample.jpphoto.viewmodel.PhotosViewModel;

import javax.inject.Inject;

public class PhotosActivity extends BindingActivity<ActivityPhotosBinding, PhotosViewModel> {

    @Inject
    PhotosViewModel photosViewModel;

    @Override
    public PhotosViewModel onCreate() {
        PhotosComponent.Injector.buildComponent(this).inject(this);
        return photosViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_photos;
    }
}
