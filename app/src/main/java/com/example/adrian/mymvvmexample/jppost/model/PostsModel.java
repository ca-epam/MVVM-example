package com.example.adrian.mymvvmexample.jppost.model;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Post;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PostService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/21/2017.
 */

public class PostsModel {

    private static final String TAG = PostsModel.class.getName();

    private final PostService postService;

    private Observer<List<Post>> postListObserver;

    private Observer<Post> postObserver;

    private OnPostsCallback callback;

    public PostsModel(PostService postService) {
        this.postService = postService;

        createPostListObserver();
        createPostObserver();

    }

    private void createPostListObserver() {
        postListObserver = new Observer<List<Post>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllPostError(e);
            }

            @Override
            public void onNext(List<Post> posts) {
                Log.i(TAG, "onNext");
                Log.i(TAG, posts.toString());
                callback.onFindAllPostSuccess(posts);
            }
        };
    }

    private void createPostObserver() {
        postObserver = new Observer<Post>() {
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
            public void onNext(Post post) {
                Log.i(TAG, "onNext");
                Log.i(TAG, post.toString());
            }
        };
    }

    public void findAllPost() {
        postService.findAllPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postListObserver);
    }

    public void registerCallback(OnPostsCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnPostsCallback {

        void onFindAllPostSuccess(List<Post> posts);

        void onFindAllPostError(Throwable t);

    }
}
