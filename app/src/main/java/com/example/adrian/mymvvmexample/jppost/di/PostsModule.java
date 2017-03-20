package com.example.adrian.mymvvmexample.jppost.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 03. 16..
 */

@Module
public class PostsModule {

    PostsActivity postsActivity;

    public PostsModule(PostsActivity postsActivity) {
        this.postsActivity = postsActivity;
    }

    @ActivityScope
    @Provides
    PostsActivity providesPostsActivity() {
        return this.postsActivity;
    }

    @ActivityScope
    @Provides
    PostsViewModel providesPostsViewModel(PostsActivity postsActivity) {
        return new PostsViewModel(postsActivity);
    }


//    @ActivityScope
//    @Provides
//    UsersView providesUsersView() {
//        return usersActivity;
//    }
//
//    @ActivityScope
//    @Provides
//    UserInteractor provideUserInteractor() {
//        return new UserInteractorImpl();
//    }

}
