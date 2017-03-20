package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {JsonPlaceholderApiBaseModule.class, JsonPlaceholderServiceModule.class})
public interface JsonPlaceholderApiComponent {

    void inject(JsonPlaceholderApiActivity jsonPlaceholderApiActivity);

    final class Injector {
        private static JsonPlaceholderApiComponent jsonPlaceholderApiComponent;

        private Injector() {
        }

        public static JsonPlaceholderApiComponent buildComponent(JsonPlaceholderApiActivity activity) {
            jsonPlaceholderApiComponent = DaggerJsonPlaceholderApiComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .jsonPlaceholderApiBaseModule(new JsonPlaceholderApiBaseModule(activity))
                    .build();

            return jsonPlaceholderApiComponent;
        }

        public static JsonPlaceholderApiComponent getJsonPlaceholderApiComponent() {
            return jsonPlaceholderApiComponent;
        }
    }

}
