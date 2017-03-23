package com.example.adrian.mymvvmexample.jpuser.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityUsersBinding;
import com.example.adrian.mymvvmexample.jpuser.di.UsersComponent;
import com.example.adrian.mymvvmexample.jpuser.viewmodel.UsersViewModel;

public class UsersActivity extends BindingActivity<ActivityUsersBinding, UsersViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        UsersComponent.Injector.buildComponent(this).inject(this);

        ActivityUsersBinding activityUsersBinding = DataBindingUtil.setContentView(this, R.layout.activity_users);

//        UsersAdapter usersAdapter = new UsersAdapter(UsersTestData.getUserViewModelData());
        activityUsersBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        activityUsersBinding.rvUsers.setAdapter(usersAdapter);

//        userInteractorImpl.toString();
//        userInteractorImpl.test();

    }

    @Override
    public UsersViewModel onCreate() {
        return null;
    }

    @Override
    public int getVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }
}
