package com.example.adrian.mymvvmexample.jptodo.viewmodel;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jptodo.model.TodosModel;
import com.example.adrian.mymvvmexample.jptodo.view.TodosActivity;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class TodosViewModel extends BaseViewModel<TodosActivity> {

    private TodosModel todosModel;

    public TodosViewModel(TodosActivity activity, TodosModel todosModel) {
        super(activity);
        this.todosModel = todosModel;
    }
}
