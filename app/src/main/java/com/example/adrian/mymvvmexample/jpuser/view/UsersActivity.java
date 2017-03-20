package com.example.adrian.mymvvmexample.jpuser.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.databinding.ActivityUsersBinding;
import com.example.adrian.mymvvmexample.jpuser.di.UsersComponent;
import com.example.adrian.mymvvmexample.jpuser.utils.UsersTestData;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.UserInteractor;

import javax.inject.Inject;
import javax.inject.Named;

public class UsersActivity extends AppCompatActivity implements UsersView {

    @Inject
    @Named("noParam")
    UserInteractor userInteractorImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        UsersComponent.Injector.buildComponent(this).inject(this);

        ActivityUsersBinding activityUsersBinding = DataBindingUtil.setContentView(this, R.layout.activity_users);

        UsersAdapter usersAdapter = new UsersAdapter(UsersTestData.getUserViewModelData());
        activityUsersBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityUsersBinding.rvUsers.setAdapter(usersAdapter);

        userInteractorImpl.toString();
//        userInteractorImpl.test();

    }
}
