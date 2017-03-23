package com.example.adrian.mymvvmexample.jpcomment.viewmodel;

import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jpcomment.model.CommentsModel;
import com.example.adrian.mymvvmexample.jpcomment.view.CommentsActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class CommentsViewModel extends BaseViewModel<CommentsActivity> implements CommentsModel.OnCommentCallback {

    private CommentsModel commentsModel;

    private List<CommentItemViewModel> commentItemViewModels = new ArrayList<>();

    private int commentItemLayoutId = R.layout.list_item_comment;

    private int variableId = BR.commentItemVM;

    public CommentsViewModel(CommentsActivity commentsActivity, CommentsModel commentsModel) {
        super(commentsActivity);
        this.commentsModel = commentsModel;

        init();
    }

    private void init() {
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

    private List<CommentItemViewModel> convertToViewModel(List<Comment> comments) {
        List<CommentItemViewModel> commentItemViewModels = new ArrayList<>();
        for (Comment c : comments) {
            commentItemViewModels.add(new CommentItemViewModel(c));
        }
        return commentItemViewModels;
    }


    @Override
    public void onFindAllCommentSuccess(List<Comment> comments) {
        setCommentItemViewModels(convertToViewModel(comments));
    }

    @Override
    public void onFindAllCommentError(Throwable t) {
        t.printStackTrace();
    }

    @Bindable
    public List<CommentItemViewModel> getCommentItemViewModels() {
        return commentItemViewModels;
    }

    public void setCommentItemViewModels(List<CommentItemViewModel> commentItemViewModels) {
        this.commentItemViewModels = commentItemViewModels;
        notifyPropertyChanged(BR.commentItemViewModels);
    }

    @Bindable
    public int getCommentItemLayoutId() {
        return commentItemLayoutId;
    }

    @Bindable
    public int getVariableId() {
        return variableId;
    }
}
