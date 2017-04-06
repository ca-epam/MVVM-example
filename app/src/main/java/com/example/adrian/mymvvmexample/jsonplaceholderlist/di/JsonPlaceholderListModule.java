package com.example.adrian.mymvvmexample.jsonplaceholderlist.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpcomment.model.CommentsModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderServiceModule;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.CommentService;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.JsonPlaceholderListModel;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.RVDataModel;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.rv.comment.RVCommentsViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.view.JsonPlaceholderListActivity;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.viewmodel.JsonPlaceholderListViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/27/2017.
 */

@Module(includes = JsonPlaceholderServiceModule.class)
public class JsonPlaceholderListModule {

    private JsonPlaceholderListActivity jsonPlaceholderListActivity;

    public JsonPlaceholderListModule(JsonPlaceholderListActivity jsonPlaceholderListActivity) {
        this.jsonPlaceholderListActivity = jsonPlaceholderListActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderListActivity providesJsonPlaceholderListActivity() {
        return this.jsonPlaceholderListActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderListModel providesJsonPlaceholderListModel() {
        return new JsonPlaceholderListModel();
    }

    @ActivityScope
    @Provides
    CommentsModel providesCommentsModel(CommentService commentService) {
        return new CommentsModel(commentService);
    }

    @ActivityScope
    @Provides
    RVCommentsViewModel providesRvCommentsViewModel(CommentsModel commentsModel) {
        return new RVCommentsViewModel(commentsModel);
    }

    @ActivityScope
    @Provides
    RVDataModel providesRvDataModel(RVCommentsViewModel rvCommentsViewModel) {
        return new RVDataModel(rvCommentsViewModel);
    }

    @ActivityScope
    @Provides
    JsonPlaceholderListViewModel providesJsonPlaceholderListViewModel(JsonPlaceholderListActivity jsonPlaceholderListActivity, RVDataModel rvDataModel) {
        return new JsonPlaceholderListViewModel(jsonPlaceholderListActivity, rvDataModel);
    }

//    @ActivityScope
//    @Provides
//    JsonPlaceholderDataModel providesJsonPlaceholderDataModel(PostsModel postsModel, CommentsModel commentsModel) {
//        return new JsonPlaceholderDataModel(postsModel, commentsModel);
//    }


}
