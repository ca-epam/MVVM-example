package com.example.adrian.mymvvmexample.jpuser.di;

import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;
import com.example.adrian.mymvvmexample.jpuser.viewmodel.UserViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderApiComponent;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 16..
 */

@Component(dependencies = JsonPlaceholderApiComponent.class, modules = {UsersModule.class})
@UserScope
public interface UsersComponent {

    void inject(UserViewModel userViewModel);

    void inject(UsersActivity usersActivity);

    final class Injector {
        private Injector() {
        }

        public static UsersComponent buildComponent(UsersActivity activity) {
            return DaggerUsersComponent.builder()
                    .jsonPlaceholderApiComponent(JsonPlaceholderApiComponent.Injector.getJsonPlaceholderApiComponent())
                    .usersModule(new UsersModule(activity))
                    .build();
        }
    }
}
