package com.example.adrian.mymvvmexample.jppost.viewmodel;

import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jppost.model.Post;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public class PostsViewModel extends BaseViewModel<PostsActivity> {

    private static final String TAG = PostsViewModel.class.getName();

    private final ObservableField<Post> postObservableField = new ObservableField<>();

    public PostsViewModel(PostsActivity activity) {
        super(activity);

        Post post = new Post();
        post.setId(1);
        post.setUserId(1);
        post.setTitle("title");
        post.setBody("body");
        postObservableField.set(post);

    }

    @Bindable
    public Integer getId() {
        return postObservableField.get().getId();
    }

    @Bindable
    public Integer getUserId() {
        return postObservableField.get().getUserId();
    }

    @Bindable
    public String getTitle() {
        return postObservableField.get().getTitle();
    }

    @Bindable
    public String getBody() {
        return postObservableField.get().getBody();
    }

    public void setUserId(final int userId) {
        postObservableField.get().setUserId(userId);
        notifyPropertyChanged(BR.userId);
    }

    public void setId(final int id) {
        postObservableField.get().setId(id);
        notifyPropertyChanged(BR.id);
    }

    public void setTitle(final String title) {
        postObservableField.get().setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    public void setBody(final String body) {
        postObservableField.get().setBody(body);
        notifyPropertyChanged(BR.body);
    }

    public ObservableField<Post> getPostObservableField() {
        return postObservableField;
    }


    public void onClickModifyPostByObject(View view) {
        Log.i(TAG, "onClickModifyPostByObject method ...");

        Post p = new Post();
        p.setUserId(3);
        p.setId(3);
        p.setTitle("title3");
        p.setBody("body3");
        postObservableField.set(p);

//        setPostObservableField(op);

        // ez is elég a módosításhoz
//        postObservableField.get().setBody("fdtdfhg");
    }

    public void onClickModifyPostByFields(View view) {
        Log.i(TAG, "onClickModifyPostByFields method ...");
        setUserId(2);
        setId(2);
        setTitle("title2");
        setBody("body2");
    }
}
