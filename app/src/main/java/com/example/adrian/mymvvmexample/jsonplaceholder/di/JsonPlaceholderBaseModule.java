package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderPresenter;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderPresenterImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@Module(includes = JsonPlaceholderInteractorModule.class)
public class JsonPlaceholderBaseModule {

    private JsonPlaceholderActivity jsonPlaceholderActivity;

    public JsonPlaceholderBaseModule(JsonPlaceholderActivity jsonPlaceholderActivity) {
        this.jsonPlaceholderActivity = jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderView providesJsonPlaceholderApiView() {
        return jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderPresenter providesJsonPlaceholderApiPresenter(JsonPlaceholderView jsonPlaceholderApiView) {
        return new JsonPlaceholderPresenterImpl(jsonPlaceholderApiView);
    }

}
