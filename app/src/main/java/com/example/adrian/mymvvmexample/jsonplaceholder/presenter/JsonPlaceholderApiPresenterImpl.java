package com.example.adrian.mymvvmexample.jsonplaceholder.presenter;

import android.content.Intent;

import com.example.adrian.mymvvmexample.jpalbum.view.AlbumsActivity;
import com.example.adrian.mymvvmexample.jpcomment.view.CommentsActivity;
import com.example.adrian.mymvvmexample.jpphoto.view.PhotosActivity;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;
import com.example.adrian.mymvvmexample.jptodo.view.TodosActivity;
import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiView;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderApiPresenterImpl implements JsonPlaceholderApiPresenter {

    private static final String TAG = JsonPlaceholderApiPresenterImpl.class.getName();

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    public JsonPlaceholderApiPresenterImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;
    }

    @Override
    public void onClickBtnFindAllPost() {
        Intent intent = new Intent((JsonPlaceholderApiActivity) jsonPlaceholderApiView, PostsActivity.class);
        ((JsonPlaceholderApiActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnPostById(final int id) {
//        postInteractor.findPostById(id);
    }

    @Override
    public void onClickBtnFindAllComment() {
        Intent intent = new Intent((JsonPlaceholderApiActivity) jsonPlaceholderApiView, CommentsActivity.class);
        ((JsonPlaceholderApiActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnFindAllAlbum() {
        Intent intent = new Intent((JsonPlaceholderApiActivity) jsonPlaceholderApiView, AlbumsActivity.class);
        ((JsonPlaceholderApiActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnFindAllPhoto() {
        Intent intent = new Intent((JsonPlaceholderApiActivity) jsonPlaceholderApiView, PhotosActivity.class);
        ((JsonPlaceholderApiActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnFindAllTodo() {
        Intent intent = new Intent((JsonPlaceholderApiActivity) jsonPlaceholderApiView, TodosActivity.class);
        ((JsonPlaceholderApiActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnFindAllUser() {
        Intent intent = new Intent((JsonPlaceholderApiActivity) jsonPlaceholderApiView, UsersActivity.class);
        ((JsonPlaceholderApiActivity) jsonPlaceholderApiView).startActivity(intent);
    }
}
