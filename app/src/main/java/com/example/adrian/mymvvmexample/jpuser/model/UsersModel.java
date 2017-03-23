package com.example.adrian.mymvvmexample.jpuser.model;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.User;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.UserService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/23/2017.
 */

public class UsersModel {

    private static final String TAG = UsersModel.class.getName();

    private final UserService userService;

    private Observer<List<User>> userListObserver;

    private Observer<User> userObserver;

    private OnUsersCallback callback;

    public UsersModel(UserService userService) {
        this.userService = userService;

        createUserListObserver();
        createUserObserver();

    }

    private void createUserListObserver() {
        userListObserver = new Observer<List<User>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllUserError(e);
            }

            @Override
            public void onNext(List<User> users) {
                Log.i(TAG, "onNext");
                Log.i(TAG, users.toString());
                callback.onFindAllUserSuccess(users);
            }
        };
    }

    private void createUserObserver() {
        userObserver = new Observer<User>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(User user) {
                Log.i(TAG, "onNext");
                Log.i(TAG, user.toString());
            }
        };
    }

    public void findAllUser() {
        userService.findAllUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userListObserver);
    }

    public void registerCallback(OnUsersCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnUsersCallback {

        void onFindAllUserSuccess(List<User> users);

        void onFindAllUserError(Throwable t);

    }
}
