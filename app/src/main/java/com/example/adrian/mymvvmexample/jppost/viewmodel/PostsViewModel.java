package com.example.adrian.mymvvmexample.jppost.viewmodel;

import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jppost.model.PostsModel;
import com.example.adrian.mymvvmexample.jppost.view.PostItemAdapter;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public class PostsViewModel extends BaseViewModel<PostsActivity> implements PostsModel.OnPostsCallback {

    private static final String TAG = PostsViewModel.class.getName();

    private PostsModel postsModel;

    private PostItemAdapter postItemAdapter;

    private List<PostItemViewModel> postItemViewModels = new ArrayList<>();

    private int variableId = getActivity().getVariable();

    private int itemLayoutId = R.layout.list_item_post;

    public PostsViewModel(PostsActivity activity, PostsModel postsModel) {
        super(activity);
        this.postsModel = postsModel;

        init();
    }

    private void init() {
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

    private List<PostItemViewModel> convertToViewModel(List<Post> posts) {
        List<PostItemViewModel> postItemViewModels = new ArrayList<>();
        for (Post p : posts) {
            postItemViewModels.add(new PostItemViewModel(p));
        }
        return postItemViewModels;
    }

    @Override
    public void onFindAllPostSuccess(List<Post> posts) {
        setPostItemViewModels(convertToViewModel(posts));
    }

    @Override
    public void onFindAllPostError(Throwable t) {
        t.printStackTrace();
    }

    @Bindable
    public List<PostItemViewModel> getPostItemViewModels() {
        return postItemViewModels;
    }

    public void setPostItemViewModels(List<PostItemViewModel> postItemViewModels) {
        this.postItemViewModels = postItemViewModels;
        notifyPropertyChanged(BR.postItemViewModels);
    }

    @Bindable
    public int getVariableId() {
        return variableId;
    }

    @Bindable
    public int getItemLayoutId() {
        return itemLayoutId;
    }
}
