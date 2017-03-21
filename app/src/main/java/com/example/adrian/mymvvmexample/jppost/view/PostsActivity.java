package com.example.adrian.mymvvmexample.jppost.view;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityPostsBinding;
import com.example.adrian.mymvvmexample.jppost.di.PostsComponent;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostsViewModel;

import javax.inject.Inject;

public class PostsActivity extends BindingActivity<ActivityPostsBinding, PostsViewModel> {

    @Inject
    PostsViewModel postsViewModel;

    private PostItemAdapter postItemAdapter;

    @Override
    public PostsViewModel onCreate() {
        PostsComponent.Injector.buildComponent(this).inject(this);
        return postsViewModel;
    }

    @Override
    public int getVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_posts;
    }

}
