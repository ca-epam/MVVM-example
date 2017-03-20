package com.example.adrian.mymvvmexample.jpuser.di;

import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;

import dagger.Module;

/**
 * Created by cadri on 2017. 03. 16..
 */

@Module
public class UsersModule {

    UsersActivity usersActivity;

    public UsersModule(UsersActivity usersActivity) {
        this.usersActivity = usersActivity;
    }

//    @ActivityScope
//    @Provides
//    UsersView providesUsersView() {
//        return usersActivity;
//    }
//
//    @ActivityScope
//    @Provides
//    UserInteractor provideUserInteractor() {
//        return new UserInteractorImpl();
//    }

}
