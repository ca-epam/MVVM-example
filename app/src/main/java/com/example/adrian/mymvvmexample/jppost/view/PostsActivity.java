package com.example.adrian.mymvvmexample.jppost.view;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityPostsBinding;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostsViewModel;

public class PostsActivity extends BindingActivity<ActivityPostsBinding, PostsViewModel> {


    @Override
    public PostsViewModel onCreate() {
        return new PostsViewModel(this);


    }

    @Override
    public int getVariable() {
        getBinding().setHandler(getViewModel());
        return BR.postViewModel;

//        return View.generateViewId();
//        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_posts;
    }
}
