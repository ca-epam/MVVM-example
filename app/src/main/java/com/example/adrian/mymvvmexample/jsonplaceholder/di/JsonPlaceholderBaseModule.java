package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderPresenter;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderPresenterImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@Module(includes = JsonPlaceholderInteractorModule.class)
public class JsonPlaceholderBaseModule {

    private JsonPlaceholderApiActivity jsonPlaceholderApiActivity;

    public JsonPlaceholderBaseModule(JsonPlaceholderApiActivity jsonPlaceholderApiActivity) {
        this.jsonPlaceholderApiActivity = jsonPlaceholderApiActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderView providesJsonPlaceholderApiView() {
        return jsonPlaceholderApiActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderPresenter providesJsonPlaceholderApiPresenter(JsonPlaceholderView jsonPlaceholderApiView) {
        return new JsonPlaceholderPresenterImpl(jsonPlaceholderApiView);
    }

}
