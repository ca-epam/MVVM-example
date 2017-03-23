package com.example.adrian.mymvvmexample.jpuser.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpuser.model.UsersModel;
import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;
import com.example.adrian.mymvvmexample.jpuser.viewmodel.UsersViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderServiceModule;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.UserService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 03. 16..
 */

@Module(includes = JsonPlaceholderServiceModule.class)
public class UsersModule {

    private UsersActivity usersActivity;

    public UsersModule(UsersActivity usersActivity) {
        this.usersActivity = usersActivity;
    }

    @ActivityScope
    @Provides
    UsersActivity providesUsersActivity() {
        return this.usersActivity;
    }

    @ActivityScope
    @Provides
    UsersModel providesUsersModel(UserService userService) {
        return new UsersModel(userService);
    }

    @ActivityScope
    @Provides
    UsersViewModel providesUsersViewModel(UsersActivity usersActivity, UsersModel usersModel) {
        return new UsersViewModel(usersActivity, usersModel);
    }


}
