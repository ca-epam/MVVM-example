package com.example.adrian.mymvvmexample.jpcomment.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Comment;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class CommentItemViewModel extends BaseObservable {

    private Comment comment;

    public CommentItemViewModel(Comment comment) {
        this.comment = comment;
    }

    @Bindable
    public Integer getPostId() {
        return comment.getPostId();
    }

    @Bindable
    public Integer getId() {
        return comment.getId();
    }

    @Bindable
    public String getName() {
        return comment.getName();
    }

    @Bindable
    public String getEmail() {
        return comment.getEmail();
    }

    @Bindable
    public String getBody() {
        return comment.getBody();
    }

    public void setPostId(Integer postId) {
        this.comment.setPostId(postId);
        notifyPropertyChanged(BR.postId);
    }

    public void setId(Integer Id) {
        this.comment.setId(Id);
        notifyPropertyChanged(BR.id);
    }

    public void setName(String name) {
        this.comment.setName(name);
        notifyPropertyChanged(BR.name);
    }

    public void setEmail(String email) {
        this.comment.setEmail(email);
        notifyPropertyChanged(BR.email);
    }

    public void setBody(String body) {
        this.comment.setBody(body);
        notifyPropertyChanged(BR.body);
    }

    @Override
    public String toString() {
        return "CommentItemViewModel{" +
                "comment=" + comment +
                '}';
    }
}
