package com.example.adrian.mymvvmexample.jsonplaceholder.presenter;

import android.content.Intent;

import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.AlbumInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.CommentInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PhotoInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PostInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.TodoInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiView;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderApiPresenterImpl implements JsonPlaceholderApiPresenter {

    private static final String TAG = JsonPlaceholderApiPresenterImpl.class.getName();

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    private PostInteractor postInteractor;

    private CommentInteractor commentInteractor;

    private AlbumInteractor albumInteractor;

    private PhotoInteractor photoInteractor;

    private TodoInteractor todoInteractor;

    private UserInteractor userInteractor;

    public JsonPlaceholderApiPresenterImpl(
            JsonPlaceholderApiView jsonPlaceholderApiView,
            PostInteractor postInteractor,
            CommentInteractor commentInteractor,
            AlbumInteractor albumInteractor,
            PhotoInteractor photoInteractor,
            TodoInteractor todoInteractor,
            UserInteractor userInteractor) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;
        this.postInteractor = postInteractor;
        this.commentInteractor = commentInteractor;
        this.albumInteractor = albumInteractor;
        this.photoInteractor = photoInteractor;
        this.todoInteractor = todoInteractor;
        this.userInteractor = userInteractor;

    }

    @Override
    public void onClickBtnFindAllPost() {
//        postInteractor.findAllPost();
        Intent intent = new Intent((JsonPlaceholderApiActivity)jsonPlaceholderApiView, PostsActivity.class);
        ((JsonPlaceholderApiActivity)jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnPostById(final int id) {
        postInteractor.findPostById(id);
    }

    @Override
    public void onClickBtnFindAllComment() {
        commentInteractor.findAllComment();
    }

    @Override
    public void onClickBtnFindAllAlbum() {
        albumInteractor.findAllAlbum();
    }

    @Override
    public void onClickBtnFindAllPhoto() {
        photoInteractor.findAllPhoto();
    }

    @Override
    public void onClickBtnFindAllTodo() {
        todoInteractor.findAllTodo();
    }

    @Override
    public void onClickBtnFindAllUser() {
        userInteractor.findAllUser();
    }
}
