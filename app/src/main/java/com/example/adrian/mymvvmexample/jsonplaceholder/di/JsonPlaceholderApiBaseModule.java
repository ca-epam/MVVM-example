package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.AlbumInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.CommentInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PhotoInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PostInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.TodoInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.UserInteractor;
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

    JsonPlaceholderApiActivity jsonPlaceholderApiActivity;

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
    JsonPlaceholderApiPresenter providesJsonPlaceholderApiPresenter(
            JsonPlaceholderApiView jsonPlaceholderApiView,
            PostInteractor postInteractor,
            CommentInteractor commentInteractor,
            AlbumInteractor albumInteractor,
            PhotoInteractor photoInteractor,
            TodoInteractor todoInteractor,
            UserInteractor userInteractor) {
        return new JsonPlaceholderApiPresenterImpl(
                jsonPlaceholderApiView,
                postInteractor,
                commentInteractor,
                albumInteractor,
                photoInteractor,
                todoInteractor,
                userInteractor);
    }

}
