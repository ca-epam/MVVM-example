package com.example.adrian.mymvvmexample.jppost.viewmodel;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jppost.model.PostModel;
import com.example.adrian.mymvvmexample.jppost.view.PostActivity;

/**
 * Created by Adrian_Czigany on 3/24/2017.
 */

public class PostViewModel extends BaseViewModel<PostActivity> {

    private PostModel postModel;

    public PostViewModel(PostActivity postActivity, PostModel postModel) {
        super(postActivity);
        this.postModel = postModel;
    }

}
