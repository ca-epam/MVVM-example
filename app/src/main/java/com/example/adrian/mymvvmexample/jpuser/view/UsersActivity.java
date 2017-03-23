package com.example.adrian.mymvvmexample.jpuser.view;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityUsersBinding;
import com.example.adrian.mymvvmexample.jpuser.di.UsersComponent;
import com.example.adrian.mymvvmexample.jpuser.viewmodel.UsersViewModel;

import javax.inject.Inject;

public class UsersActivity extends BindingActivity<ActivityUsersBinding, UsersViewModel> {

    @Inject
    UsersViewModel usersViewModel;

    @Override
    public UsersViewModel onCreate() {
        UsersComponent.Injector.buildComponent(this).inject(this);
        return usersViewModel;
    }

    @Override
    public int getVariable() {
        return BR.usersVM;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_users;
    }
}
