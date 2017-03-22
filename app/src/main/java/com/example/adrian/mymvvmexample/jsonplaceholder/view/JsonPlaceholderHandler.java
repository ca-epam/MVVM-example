package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class JsonPlaceholderHandler {

    private Context context;

    public JsonPlaceholderHandler(Context context) {
        this.context = context;
    }

    private static final String TAG = JsonPlaceholderHandler.class.getName();

    public void onClickBtnJsonPlaceholderList(View view) {
        Log.i(TAG, "OnClickBtnPost method");
        Intent intent = new Intent(context, JsonPlaceholderApiListActivity.class);
        context.startActivity(intent);
    }

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
        Intent intent = new Intent(context.getApplicationContext(), UsersActivity.class);
        context.startActivity(intent);
    }

}
