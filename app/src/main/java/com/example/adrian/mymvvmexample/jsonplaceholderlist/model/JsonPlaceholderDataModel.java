package com.example.adrian.mymvvmexample.jsonplaceholderlist.model;

import com.example.adrian.mymvvmexample.jpcomment.model.CommentsModel;
import com.example.adrian.mymvvmexample.jppost.model.PostsModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Comment;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Post;

import java.util.List;

/**
 * Created by cadri on 2017. 03. 27..
 */

public class JsonPlaceholderDataModel implements PostsModel.OnPostsCallback, CommentsModel.OnCommentCallback {

    private PostsModel postsModel;

    private CommentsModel commentsModel;

    public JsonPlaceholderDataModel(PostsModel postsModel, CommentsModel commentsModel) {
        this.postsModel = postsModel;
        this.commentsModel = commentsModel;

        postsModel.registerCallback(this);
        commentsModel.registerCallback(this);
    }

    public PostsModel getPostsModel() {
        return postsModel;
    }

    public void setPostsModel(PostsModel postsModel) {
        this.postsModel = postsModel;
    }

    public CommentsModel getCommentsModel() {
        return commentsModel;
    }

    public void setCommentsModel(CommentsModel commentsModel) {
        this.commentsModel = commentsModel;
    }

    public void getAllPost() {
        postsModel.findAllPost();
    }

    public void getAllComment() {
        commentsModel.findAllComment();
    }

    @Override
    public void onFindAllPostSuccess(List<Post> posts) {

    }

    @Override
    public void onFindAllPostError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onFindAllCommentSuccess(List<Comment> comments) {

    }

    @Override
    public void onFindAllCommentError(Throwable t) {
        t.printStackTrace();
    }
}
