package com.example.adrian.mymvvmexample.jpcomment.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpcomment.model.CommentsModel;
import com.example.adrian.mymvvmexample.jpcomment.view.CommentsActivity;
import com.example.adrian.mymvvmexample.jpcomment.viewmodel.CommentsViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderServiceModule;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.CommentService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

@Module(includes = {JsonPlaceholderServiceModule.class})
public class CommentsModule {

    private CommentsActivity commentsActivity;

    public CommentsModule(CommentsActivity commentsActivity) {
        this.commentsActivity = commentsActivity;
    }

    @ActivityScope
    @Provides
    CommentsActivity providesCommentsActivity() {
        return this.commentsActivity;
    }

    @ActivityScope
    @Provides
    CommentsModel providesCommentsModel(CommentService commentService) {
        return new CommentsModel(commentService);
    }

    @ActivityScope
    @Provides
    CommentsViewModel providesCommentsViewModel(CommentsActivity commentsActivity, CommentsModel commentsModel) {
        return new CommentsViewModel(commentsActivity, commentsModel);
    }
}
