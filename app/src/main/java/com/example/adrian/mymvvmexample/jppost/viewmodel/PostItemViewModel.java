package com.example.adrian.mymvvmexample.jppost.viewmodel;

import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.common.ListItemViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Post;

/**
 * Created by Adrian_Czigany on 3/21/2017.
 */

public class PostItemViewModel extends ListItemViewModel {

    private Post post;

    public PostItemViewModel(Post post) {
        this.post = post;
    }

    @Bindable
    public Integer getUserId() {
        return post.getUserId();
    }

    @Bindable
    public Integer getId() {
        return post.getId();
    }

    @Bindable
    public String getTitle() {
        return post.getTitle();
    }

    @Bindable
    public String getBody() {
        return post.getBody();
    }

    public void setUserId(final int userId) {
        post.setUserId(userId);
        notifyPropertyChanged(BR.userId);
    }

    public void setId(final int id) {
        post.setId(id);
        notifyPropertyChanged(BR.id);
    }

    public void setTitle(final String title) {
        post.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    public void setBody(final String body) {
        post.setBody(body);
        notifyPropertyChanged(BR.body);
    }

    @Override
    public String toString() {
        return "PostItemViewModel{" +
                "post=" + post +
                '}';
    }

}
