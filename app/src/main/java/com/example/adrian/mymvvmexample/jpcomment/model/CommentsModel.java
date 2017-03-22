package com.example.adrian.mymvvmexample.jpcomment.model;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Comment;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.CommentService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class CommentsModel {

    private static final String TAG = CommentsModel.class.getName();

    private final CommentService commentService;

    private Observer<List<Comment>>commentListObserver;

    private Observer<Comment> commentObserver;

    private OnCommentCallback callback;

    public CommentsModel(CommentService commentService) {
        this.commentService = commentService;

        createCommentListObserver();
        createCommentObserver();

    }

    private void createCommentListObserver() {
        commentListObserver = new Observer<List<Comment>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllCommentError(e);
            }

            @Override
            public void onNext(List<Comment> comments) {
                Log.i(TAG, "onNext");
                Log.i(TAG, comments.toString());
                callback.onFindAllCommentSuccess(comments);
            }
        };
    }

    private void createCommentObserver() {
        commentObserver = new Observer<Comment>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(Comment comment) {
                Log.i(TAG, "onNext");
                Log.i(TAG, comment.toString());
            }
        };
    }

    public void findAllComment() {
        commentService.findAllComment()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commentListObserver);
    }

    public void registerCallback(OnCommentCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnCommentCallback {

        void onFindAllCommentSuccess(List<Comment> comments);

        void onFindAllCommentError(Throwable t);

    }
}
