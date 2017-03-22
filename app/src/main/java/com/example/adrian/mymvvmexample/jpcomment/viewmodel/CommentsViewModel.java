package com.example.adrian.mymvvmexample.jpcomment.viewmodel;

import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jpcomment.model.CommentsModel;
import com.example.adrian.mymvvmexample.jpcomment.view.CommentItemAdapter;
import com.example.adrian.mymvvmexample.jpcomment.view.CommentsActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class CommentsViewModel extends BaseViewModel<CommentsActivity> implements CommentsModel.OnCommentCallback {

    private CommentsModel commentsModel;

    private CommentItemAdapter commentItemAdapter;

    public CommentsViewModel(CommentsActivity commentsActivity, CommentsModel commentsModel) {
        super(commentsActivity);
        this.commentsModel = commentsModel;

        getActivity().getBinding().rvComments.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        commentsModel.findAllComment();
    }

    @Override
    public void onStart() {
        super.onStart();
        commentsModel.registerCallback(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        commentsModel.unRegisterCallback();
    }

    private void setUpRecyclerView(List<CommentItemViewModel> commentItemViewModels) {
        commentItemAdapter = new CommentItemAdapter(commentItemViewModels);

        getActivity().getBinding().rvComments.setAdapter(commentItemAdapter);
    }

    private List<CommentItemViewModel> convertToViewModel(List<Comment> comments) {
        List<CommentItemViewModel> commentItemViewModels = new ArrayList<>();
        for (Comment c : comments) {
            commentItemViewModels.add(new CommentItemViewModel(c));
        }
        return commentItemViewModels;
    }


    @Override
    public void onFindAllCommentSuccess(List<Comment> comments) {
        setUpRecyclerView(convertToViewModel(comments));
    }

    @Override
    public void onFindAllCommentError(Throwable t) {
        t.printStackTrace();
    }
}
