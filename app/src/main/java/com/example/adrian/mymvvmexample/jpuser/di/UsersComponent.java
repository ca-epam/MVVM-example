package com.example.adrian.mymvvmexample.jpuser.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;
import com.example.adrian.mymvvmexample.jpuser.viewmodel.UserViewModel;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 16..
 */

@Component(dependencies = AppComponent.class, modules = {UsersModule.class})
@ActivityScope
public interface UsersComponent {

    void inject(UserViewModel userViewModel);

    void inject(UsersActivity usersActivity);

    final class Injector {
        private Injector() {
        }

        public static UsersComponent buildComponent(UsersActivity activity) {
            return DaggerUsersComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .usersModule(new UsersModule(activity))
                    .build();
        }
    }
}
