package com.example.adrian.mymvvmexample.jsonplaceholderlist.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpcomment.model.CommentsModel;
import com.example.adrian.mymvvmexample.jppost.model.PostsModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderServiceModule;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.JsonPlaceholderDataModel;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.JsonPlaceholderListModel;
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
    JsonPlaceholderListViewModel providesJsonPlaceholderListViewModel(JsonPlaceholderListActivity jsonPlaceholderListActivity, JsonPlaceholderListModel jsonPlaceholderListModel) {
        return new JsonPlaceholderListViewModel(jsonPlaceholderListActivity, jsonPlaceholderListModel);
    }

    @ActivityScope
    @Provides
    JsonPlaceholderDataModel providesJsonPlaceholderDataModel(PostsModel postsModel, CommentsModel commentsModel) {
        return new JsonPlaceholderDataModel(postsModel, commentsModel);

    }

}
