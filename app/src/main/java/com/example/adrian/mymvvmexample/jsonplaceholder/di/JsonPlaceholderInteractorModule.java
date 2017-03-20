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
import com.example.adrian.mymvvmexample.jsonplaceholder.service.AlbumService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.CommentService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PhotoService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PostService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.TodoService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.UserService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

@Module(includes = JsonPlaceholderServiceModule.class)
public class JsonPlaceholderInteractorModule {

    @ActivityScope
    @Provides
    PostInteractor providePostInteractor(PostService postService) {
        return new PostInteractorImpl(postService);
    }

    @ActivityScope
    @Provides
    CommentInteractor provideCommentInteractor(CommentService commentService) {
        return new CommentInteractorImpl(commentService);
    }

    @ActivityScope
    @Provides
    AlbumInteractor provideAlbumInteractor(AlbumService albumService) {
        return new AlbumInteractorImpl(albumService);
    }

    @ActivityScope
    @Provides
    PhotoInteractor providePhotoInteractor(PhotoService photoService) {
        return new PhotoInteractorImpl(photoService);
    }

    @ActivityScope
    @Provides
    TodoInteractor provideTodoInteractor(TodoService todoService) {
        return new TodoInteractorImpl(todoService);
    }

    @ActivityScope
    @Provides
    UserInteractor provideUserInteractor(UserService userService) {
        return new UserInteractorImpl(userService);
    }

}
