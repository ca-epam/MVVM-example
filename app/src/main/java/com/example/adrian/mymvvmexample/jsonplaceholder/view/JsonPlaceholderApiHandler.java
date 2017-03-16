package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.util.Log;
import android.view.View;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class JsonPlaceholderApiHandler {

    private static final String TAG = JsonPlaceholderApiHandler.class.getName();

    public void onClickBtnPost(View view) {
        Log.i(TAG, "OnClickBtnPost method");
    }

    public void onClickBtnFindAllComment(View view) {
        Log.i(TAG, "onClickBtnFindAllComment method");
    }

    public void onClickBtnFindAllAlbum(View view) {
        Log.i(TAG, "onClickBtnFindAllAlbum method");
    }

    public void onClickBtnFindAllPhoto(View view) {
        Log.i(TAG, "onClickBtnFindAllPhoto method");
    }

    public void onClickBtnFindAllTodo(View view) {
        Log.i(TAG, "onClickBtnFindAllTodo method");
    }

    public void onClickBtnFindAllUser(View view) {
        Log.i(TAG, "onClickBtnFindAllUser method");
    }

}
