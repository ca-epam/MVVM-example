package com.example.adrian.mymvvmexample.jpcomment.view;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityCommentsBinding;
import com.example.adrian.mymvvmexample.jpcomment.di.CommentsComponent;
import com.example.adrian.mymvvmexample.jpcomment.viewmodel.CommentsViewModel;

import javax.inject.Inject;

public class CommentsActivity extends BindingActivity<ActivityCommentsBinding, CommentsViewModel> {

    @Inject
    CommentsViewModel commentsViewModel;

    @Override
    public CommentsViewModel onCreate() {
        CommentsComponent.Injector.buildComponent(this).inject(this);
        return commentsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_comments;
    }
}
