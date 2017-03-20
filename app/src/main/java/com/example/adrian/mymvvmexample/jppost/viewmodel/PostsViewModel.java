package com.example.adrian.mymvvmexample.jppost.viewmodel;

import android.util.Log;
import android.view.View;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jppost.model.Post;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public class PostsViewModel extends BaseViewModel<PostsActivity> {

    private static final String TAG = PostsViewModel.class.getName();

    private Post post;

    public PostsViewModel(PostsActivity activity) {
        super(activity);

        post = new Post();
        post.setId(1);
        post.setUserId(1);
        post.setTitle("title");
        post.setBody("body");

    }

    public Integer getId() {
        return post.getId();
    }

    public Integer getUserId() {
        return post.getUserId();
    }

    public String getTitle() {
        return post.getTitle();
    }

    public String getBody() {
        return post.getBody();
    }

    public void onClickModifyPost(View view) {
        Log.i(TAG, "onClickModifyPost method ...");
        post.setBody("body2");
        getActivity().getBinding().setVariable(getActivity().getVariable(), this);
        Log.i(TAG, post.toString());
    }
}
