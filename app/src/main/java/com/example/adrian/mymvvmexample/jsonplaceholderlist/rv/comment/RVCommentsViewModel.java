package com.example.adrian.mymvvmexample.jsonplaceholderlist.rv.comment;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.jpcomment.model.CommentsModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Comment;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.viewpager.ViewPagerViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class RVCommentsViewModel extends ViewPagerViewModel implements CommentsModel.OnCommentCallback {

    private CommentsModel commentsModel;

//    private List<RVCommentItemViewModel> rvCommentItemViewModels = new ArrayList<>();

    public static List<RVCommentItemViewModel> rvCommentItemViewModels = getTestList();

    public int commentItemLayoutId = R.layout.rv_list_item_comment;

    public int variableId = BR.rvCommentItemVM;

    public RVCommentsViewModel(CommentsModel commentsModel) {
        this.commentsModel = commentsModel;

        setItemLayoutId(commentItemLayoutId);
        setItemViewModels(rvCommentItemViewModels);
        setVariableId(variableId);

        init();
    }

    private void init() {
//        getActivity().getBinding().rvComments.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

//        rvCommentItemViewModels = getTestList();
//        commentsModel.findAllComment();
    }

//    @Override
    public void onStart() {
        commentsModel.registerCallback(this);
    }

//    @Override
    public void onStop() {
        commentsModel.unRegisterCallback();
    }

    private List<RVCommentItemViewModel> convertToViewModel(List<Comment> comments) {
        List<RVCommentItemViewModel> RVCommentItemViewModels = new ArrayList<>();
        for (Comment c : comments) {
            RVCommentItemViewModels.add(new RVCommentItemViewModel(c));
        }
        return RVCommentItemViewModels;
    }


    @Override
    public void onFindAllCommentSuccess(List<Comment> comments) {
//        setRvCommentItemViewModels(convertToViewModel(comments));
    }

    @Override
    public void onFindAllCommentError(Throwable t) {
//        t.printStackTrace();
    }

//    @Bindable
//    public List<RVCommentItemViewModel> getRvCommentItemViewModels() {
//        return rvCommentItemViewModels;
//    }
//
//    public void setRvCommentItemViewModels(List<RVCommentItemViewModel> rvCommentItemViewModels) {
//        this.rvCommentItemViewModels = rvCommentItemViewModels;
//        notifyPropertyChanged(BR.commentItemViewModels);
//    }
//
//    @Bindable
//    public int getCommentItemLayoutId() {
//        return commentItemLayoutId;
//    }
//
//    @Bindable
//    public int getVariableId() {
//        return variableId;
//    }

    public static List<RVCommentItemViewModel> getTestList() {
        List<RVCommentItemViewModel> list = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setPostId(1);
        comment1.setName("name1");
        comment1.setBody("body1");
        comment1.setEmail("email1");

        Comment comment2 = new Comment();
        comment2.setId(2);
        comment2.setPostId(2);
        comment2.setName("name2");
        comment2.setBody("body2");
        comment2.setEmail("email2");

        Comment comment3 = new Comment();
        comment3.setId(3);
        comment3.setPostId(3);
        comment3.setName("name3");
        comment3.setBody("body3");
        comment3.setEmail("email3");
        RVCommentItemViewModel rvCommentItemViewModel1 = new RVCommentItemViewModel(comment1);
        RVCommentItemViewModel rvCommentItemViewModel2 = new RVCommentItemViewModel(comment2);
        RVCommentItemViewModel rvCommentItemViewModel3 = new RVCommentItemViewModel(comment3);
        list.add(rvCommentItemViewModel1);
        list.add(rvCommentItemViewModel2);
        list.add(rvCommentItemViewModel3);
        return list;
    }
}
