package com.example.adrian.mymvvmexample.jptodo.model;

import com.example.adrian.mymvvmexample.jsonplaceholder.service.TodoService;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class TodosModel {

    private TodoService todoService;

    public TodosModel(TodoService todoService) {
        this.todoService = todoService;
    }
}
