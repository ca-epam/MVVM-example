package com.example.adrian.mymvvmexample.jsonplaceholderlist.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.view.JsonPlaceholderListActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/27/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {JsonPlaceholderListModule.class})
public interface JsonPlaceholderListComponent {

    public void inject(JsonPlaceholderListActivity jsonPlaceholderListActivity);

    final class Injector {
        private Injector() {
        }

        public static JsonPlaceholderListComponent buildComponent(JsonPlaceholderListActivity activity) {
            return DaggerJsonPlaceholderListComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .jsonPlaceholderListModule(new JsonPlaceholderListModule(activity))
                    .build();
        }
    }
}
