package com.example.adrian.mymvvmexample.jpuser.viewmodel;

import android.content.Context;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jpuser.model.UsersModel;
import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.User;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class UsersViewModel extends BaseViewModel<UsersActivity> {

    private static final String TAG = UsersViewModel.class.getName();

    private UsersModel usersModel;

    private List<User> users;

    private Context context;

    public UsersViewModel(UsersActivity activity, UsersModel usersModel) {
        super(activity);
        this.usersModel = usersModel;

        init();
    }

    private void init() {

    }
}
