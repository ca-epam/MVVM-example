package com.example.adrian.mymvvmexample.jppost.view;

import android.content.Intent;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityPostsBinding;
import com.example.adrian.mymvvmexample.jppost.di.PostsComponent;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostsViewModel;

import javax.inject.Inject;

public class PostsActivity extends BindingActivity<ActivityPostsBinding, PostsViewModel> {

    @Inject
    PostsViewModel postsViewModel;

    @Override
    public PostsViewModel onCreate() {
        PostsComponent.Injector.buildComponent(this).inject(this);
        return postsViewModel;
    }

    @Override
    public int getVariable() {
        return BR.postsVM;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_posts;
    }

    public void openPostPage() {
        Intent intent = new Intent(PostsActivity.this, PostActivity.class);
        startActivity(intent);
    }

}
