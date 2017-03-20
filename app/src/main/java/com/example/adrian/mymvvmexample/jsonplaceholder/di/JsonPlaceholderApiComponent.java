package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.AlbumInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.CommentInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PhotoInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.PostInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.TodoInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvvmexample.jsonplaceholder.interactor.UserInteractorImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenterImpl;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.UserService;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {JsonPlaceholderApiBaseModule.class, JsonPlaceholderServiceModule.class})
public interface JsonPlaceholderApiComponent {

    void inject(JsonPlaceholderApiActivity jsonPlaceholderApiActivity);

    void inject(JsonPlaceholderApiPresenterImpl jsonPlaceholderApiPresenterImpl);

    void inject(PostInteractorImpl postInteractorImpl);

    void inject(CommentInteractorImpl commentInteractorImpl);

    void inject(AlbumInteractorImpl albumInteractorImpl);

    void inject(PhotoInteractorImpl photoInteractorImpl);

    void inject(TodoInteractorImpl todoInteractorImpl);

    void inject(UserInteractorImpl userInteractorImpl);

    UserInteractor userInteractor();

    @Named("noParam")
    UserInteractor userInteractor2();

    UserService userService();

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
