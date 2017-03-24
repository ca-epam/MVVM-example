package com.example.adrian.mymvvmexample.jppost.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jppost.model.PostModel;
import com.example.adrian.mymvvmexample.jppost.view.PostActivity;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderServiceModule;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PostService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/24/2017.
 */

@Module(includes = {JsonPlaceholderServiceModule.class})
public class PostModule {

    private PostActivity postActivity;

    public PostModule(PostActivity postActivity) {
        this.postActivity = postActivity;
    }

    @ActivityScope
    @Provides
    PostActivity providesPostActivity() {
        return this.postActivity;
    }

    @ActivityScope
    @Provides
    PostModel providesPostsModel(PostService postService) {
        return new PostModel(postService);
    }

    @ActivityScope
    @Provides
    PostViewModel providesPostViewModel(PostActivity postActivity, PostModel postModel) {
        return new PostViewModel(postActivity, postModel);
    }
}
