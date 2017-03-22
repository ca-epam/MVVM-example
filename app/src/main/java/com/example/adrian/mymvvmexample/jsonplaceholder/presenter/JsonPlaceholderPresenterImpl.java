package com.example.adrian.mymvvmexample.jsonplaceholder.presenter;

import android.content.Intent;

import com.example.adrian.mymvvmexample.jpalbum.view.AlbumsActivity;
import com.example.adrian.mymvvmexample.jpcomment.view.CommentsActivity;
import com.example.adrian.mymvvmexample.jpphoto.view.PhotosActivity;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;
import com.example.adrian.mymvvmexample.jptodo.view.TodosActivity;
import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderView;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderPresenterImpl implements JsonPlaceholderPresenter {

    private static final String TAG = JsonPlaceholderPresenterImpl.class.getName();

    private JsonPlaceholderView jsonPlaceholderApiView;

    public JsonPlaceholderPresenterImpl(JsonPlaceholderView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;
    }

    @Override
    public void onClickBtnFindAllPost() {
        Intent intent = new Intent((JsonPlaceholderActivity) jsonPlaceholderApiView, PostsActivity.class);
        ((JsonPlaceholderActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnPostById(final int id) {
//        postInteractor.findPostById(id);
    }

    @Override
    public void onClickBtnFindAllComment() {
        Intent intent = new Intent((JsonPlaceholderActivity) jsonPlaceholderApiView, CommentsActivity.class);
        ((JsonPlaceholderActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnFindAllAlbum() {
        Intent intent = new Intent((JsonPlaceholderActivity) jsonPlaceholderApiView, AlbumsActivity.class);
        ((JsonPlaceholderActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnFindAllPhoto() {
        Intent intent = new Intent((JsonPlaceholderActivity) jsonPlaceholderApiView, PhotosActivity.class);
        ((JsonPlaceholderActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnFindAllTodo() {
        Intent intent = new Intent((JsonPlaceholderActivity) jsonPlaceholderApiView, TodosActivity.class);
        ((JsonPlaceholderActivity) jsonPlaceholderApiView).startActivity(intent);
    }

    @Override
    public void onClickBtnFindAllUser() {
        Intent intent = new Intent((JsonPlaceholderActivity) jsonPlaceholderApiView, UsersActivity.class);
        ((JsonPlaceholderActivity) jsonPlaceholderApiView).startActivity(intent);
    }
}
