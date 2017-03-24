package com.example.adrian.mymvvmexample.jpalbum.view;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityAlbumsBinding;
import com.example.adrian.mymvvmexample.jpalbum.di.AlbumsComponent;
import com.example.adrian.mymvvmexample.jpalbum.viewmodel.AlbumsViewModel;

import javax.inject.Inject;

public class AlbumsActivity extends BindingActivity<ActivityAlbumsBinding, AlbumsViewModel> {

    @Inject
    AlbumsViewModel albumsViewModel;

    @Override
    public AlbumsViewModel onCreate() {
        AlbumsComponent.Injector.buildComponent(this).inject(this);
        return albumsViewModel;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_albums;
    }

}
