package com.example.adrian.mymvvmexample.jptodo.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jptodo.model.TodosModel;
import com.example.adrian.mymvvmexample.jptodo.view.TodosActivity;
import com.example.adrian.mymvvmexample.jptodo.viewmodel.TodosViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderServiceModule;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.TodoService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

@Module(includes = JsonPlaceholderServiceModule.class)
public class TodosModule {

    private TodosActivity todosActivity;

    public TodosModule(TodosActivity todosActivity) {
        this.todosActivity = todosActivity;
    }

    @ActivityScope
    @Provides
    TodosActivity providesTodosActivity() {
        return this.todosActivity;
    }

    @ActivityScope
    @Provides
    TodosModel providesTodosModel(TodoService todoService) {
        return new TodosModel(todoService);
    }

    @ActivityScope
    @Provides
    TodosViewModel providesTodosViewModel(TodosActivity todosActivity, TodosModel todosModel) {
        return new TodosViewModel(todosActivity, todosModel);
    }

}
