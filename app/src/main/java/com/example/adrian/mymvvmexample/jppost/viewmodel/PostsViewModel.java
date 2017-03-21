package com.example.adrian.mymvvmexample.jppost.viewmodel;

import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jppost.model.Post;
import com.example.adrian.mymvvmexample.jppost.view.PostItemAdapter;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PostInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PostService;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public class PostsViewModel extends BaseViewModel<PostsActivity> {

    private static final String TAG = PostsViewModel.class.getName();

    private final ObservableField<Post> postObservableField = new ObservableField<>();

    private PostInteractor postInteractor;

    private PostService postService;

    private PostItemAdapter postItemAdapter;

    private Observer<List<Post>> postListObserver;
    private Observer<Post> postObserver;

    public PostsViewModel(PostsActivity activity, PostService postService) {
        super(activity);
        this.postService = postService;

        createPostListObserver();
        createPostObserver();

        getActivity().getBinding().rvPosts.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        
        findAllPost();

    }

    private void setUpRecyclerView(List<Post> posts) {
        List<PostItemViewModel> postItemViewModels = new ArrayList<>();
        for(Post p : posts) {
            postItemViewModels.add(new PostItemViewModel(p));
        }

        postItemAdapter = new PostItemAdapter(postItemViewModels);

        getActivity().getBinding().rvPosts.setAdapter(postItemAdapter);
    }

    private void createPostListObserver() {
        Log.i(TAG, "createPostListObserver ...");

        postListObserver = new Observer<List<Post>>() {
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
            public void onNext(List<Post> posts) {
                Log.i(TAG, "onNext");
                Log.i(TAG, posts.toString());
                setUpRecyclerView(posts);
            }
        };
    }

    private void createPostObserver() {
        Log.i(TAG, "createPostObserver ...");

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

    public static List<PostItemViewModel> getPostList() {
        Post post1 = new Post();
        post1.setId(1);
        post1.setUserId(1);
        post1.setTitle("title");
        post1.setBody("body");
        PostItemViewModel postItemViewModel1 = new PostItemViewModel(post1);
        Post post2 = new Post();
        post2.setId(2);
        post2.setUserId(2);
        post2.setTitle("title2");
        post2.setBody("body2");
        PostItemViewModel postItemViewModel2 = new PostItemViewModel(post2);

        List<PostItemViewModel> list = new ArrayList<>();
        list.add(postItemViewModel1);
        list.add(postItemViewModel2);

        return list;
    }

    public static List<PostItemViewModel> getPostObservableList() {

        return null;
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

}
