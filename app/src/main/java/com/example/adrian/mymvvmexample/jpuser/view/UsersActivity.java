package com.example.adrian.mymvvmexample.jpuser.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityUsersBinding;
import com.example.adrian.mymvvmexample.jpuser.di.UsersComponent;
import com.example.adrian.mymvvmexample.jpuser.utils.UsersTestData;

public class UsersActivity extends BaseActivity implements UsersView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        UsersComponent.Injector.buildComponent(this).inject(this);

        ActivityUsersBinding activityUsersBinding = DataBindingUtil.setContentView(this, R.layout.activity_users);

        UsersAdapter usersAdapter = new UsersAdapter(UsersTestData.getUserViewModelData());
        activityUsersBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityUsersBinding.rvUsers.setAdapter(usersAdapter);

//        userInteractorImpl.toString();
//        userInteractorImpl.test();

    }
}
