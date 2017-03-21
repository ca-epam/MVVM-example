package com.example.adrian.mymvvmexample.jppost.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jppost.model.PostsModel;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostsViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderInteractorModule;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PostService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 03. 16..
 */

@Module(includes = JsonPlaceholderInteractorModule.class)
public class PostsModule {

    private PostsActivity postsActivity;

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
    PostsModel providesPostsModel(PostService postService) {
        return new PostsModel(postService);
    }

    @ActivityScope
    @Provides
    PostsViewModel providesPostsViewModel(PostsActivity postsActivity, PostsModel postsModel) {
        return new PostsViewModel(postsActivity, postsModel);
    }

}
