package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {JsonPlaceholderBaseModule.class, JsonPlaceholderServiceModule.class})
public interface JsonPlaceholderComponent {

    void inject(JsonPlaceholderApiActivity jsonPlaceholderApiActivity);

    final class Injector {
        private static JsonPlaceholderComponent jsonPlaceholderComponent;

        private Injector() {
        }

        public static JsonPlaceholderComponent buildComponent(JsonPlaceholderApiActivity activity) {
            jsonPlaceholderComponent = DaggerJsonPlaceholderComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .jsonPlaceholderBaseModule(new JsonPlaceholderBaseModule(activity))
                    .build();
            return jsonPlaceholderComponent;
        }

        public static JsonPlaceholderComponent getJsonPlaceholderComponent() {
            return jsonPlaceholderComponent;
        }
    }

}
