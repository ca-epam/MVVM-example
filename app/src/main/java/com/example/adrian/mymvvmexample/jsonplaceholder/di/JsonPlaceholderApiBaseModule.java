package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenter;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenterImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@Module(includes = JsonPlaceholderInteractorModule.class)
public class JsonPlaceholderApiBaseModule {

    private JsonPlaceholderApiActivity jsonPlaceholderApiActivity;

    public JsonPlaceholderApiBaseModule(JsonPlaceholderApiActivity jsonPlaceholderApiActivity) {
        this.jsonPlaceholderApiActivity = jsonPlaceholderApiActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderApiView providesJsonPlaceholderApiView() {
        return jsonPlaceholderApiActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderApiPresenter providesJsonPlaceholderApiPresenter(JsonPlaceholderApiView jsonPlaceholderApiView) {
        return new JsonPlaceholderApiPresenterImpl(jsonPlaceholderApiView);
    }

}
