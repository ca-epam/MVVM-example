package com.example.adrian.mymvvmexample.jppost.view;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityPostBinding;
import com.example.adrian.mymvvmexample.jppost.di.PostComponent;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostViewModel;

import javax.inject.Inject;

public class PostActivity extends BindingActivity<ActivityPostBinding, PostViewModel> {

    @Inject
    PostViewModel postViewModel;

    @Override
    public PostViewModel onCreate() {
        PostComponent.Injector.buildComponent(this).inject(this);
        return postViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_post;
    }
}
