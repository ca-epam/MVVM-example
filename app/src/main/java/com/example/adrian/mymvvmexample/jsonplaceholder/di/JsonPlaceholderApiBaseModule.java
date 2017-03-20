package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.AlbumInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.AlbumInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.CommentInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.CommentInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PhotoInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PhotoInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PostInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PostInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.TodoInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.TodoInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.UserInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenter;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenterImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@Module
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
    PostInteractor providePostInteractor() {
        return new PostInteractorImpl(providesJsonPlaceholderApiView());
    }

    @ActivityScope
    @Provides
    CommentInteractor provideCommentInteractor() {
        return new CommentInteractorImpl(providesJsonPlaceholderApiView());
    }

    @ActivityScope
    @Provides
    AlbumInteractor provideAlbumInteractor() {
        return new AlbumInteractorImpl(providesJsonPlaceholderApiView());
    }

    @ActivityScope
    @Provides
    PhotoInteractor providePhotoInteractor() {
        return new PhotoInteractorImpl(providesJsonPlaceholderApiView());
    }

    @ActivityScope
    @Provides
    TodoInteractor provideTodoInteractor() {
        return new TodoInteractorImpl(providesJsonPlaceholderApiView());
    }

    @ActivityScope
    @Provides
    UserInteractor provideUserInteractor() {
        return new UserInteractorImpl(providesJsonPlaceholderApiView());
    }

    @ActivityScope
    @Provides
    @Named("noParam")
    UserInteractor provideUserInteractor2() {
        return new UserInteractorImpl();
    }

    @ActivityScope
    @Provides
    JsonPlaceholderApiPresenter providesJsonPlaceholderApiPresenter() {
        return new JsonPlaceholderApiPresenterImpl(providesJsonPlaceholderApiView());
    }

}
