package com.example.adrian.mymvvmexample.jppost.viewmodel;

import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jppost.domain.Post;
import com.example.adrian.mymvvmexample.jppost.model.PostsModel;
import com.example.adrian.mymvvmexample.jppost.view.PostItemAdapter;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public class PostsViewModel extends BaseViewModel<PostsActivity> implements PostsModel.OnPostsCallback {

    private static final String TAG = PostsViewModel.class.getName();

    private PostsModel postsModel;

    private PostItemAdapter postItemAdapter;

    public PostsViewModel(PostsActivity activity, PostsModel postsModel) {
        super(activity);
        this.postsModel = postsModel;

        getActivity().getBinding().rvPosts.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        postsModel.findAllPost();
    }

    @Override
    public void onStart() {
        super.onStart();
        postsModel.registerCallback(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        postsModel.unRegisterCallback();
    }

    private void setUpRecyclerView(List<PostItemViewModel> postItemViewModels) {
        postItemAdapter = new PostItemAdapter(postItemViewModels);

        getActivity().getBinding().rvPosts.setAdapter(postItemAdapter);
    }

    private List<PostItemViewModel> convertToViewModel(List<Post> posts) {
        List<PostItemViewModel> postItemViewModels = new ArrayList<>();
        for(Post p : posts) {
            postItemViewModels.add(new PostItemViewModel(p));
        }
        return postItemViewModels;
    }

    @Override
    public void onFindAllPostSuccess(List<Post> posts) {
        setUpRecyclerView(convertToViewModel(posts));
    }

    @Override
    public void onFindAllPostError(Throwable t) {
        t.printStackTrace();
    }

}
