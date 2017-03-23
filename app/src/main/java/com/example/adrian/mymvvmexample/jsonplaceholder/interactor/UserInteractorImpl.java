package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.User;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.UserService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class UserInteractorImpl implements UserInteractor {

    private static final String TAG = UserInteractorImpl.class.getName();

    private Observer<List<User>> userListObserver;
    private Observer<User> userObserver;


    private UserService userService;

    public UserInteractorImpl(UserService userService) {
        this.userService = userService;

        createUserListObserver();
        createUserObserver();
    }

    private void createUserListObserver() {
        Log.i(TAG, "createUserListObserver ...");

        userListObserver = new Observer<List<User>>() {
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
            public void onNext(List<User> users) {
                Log.i(TAG, "onNext");
                Log.i(TAG, users.toString());
            }
        };
    }

    private void createUserObserver() {
        Log.i(TAG, "createUserObserver ...");

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

    @Override
    public void findAllUser() {
        userService.findAllUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userListObserver);
    }
}
