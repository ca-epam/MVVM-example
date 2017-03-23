package com.example.adrian.mymvvmexample.jsonplaceholder.service;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Todo;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface TodoService {

    @GET("/todos")
    Observable<List<Todo>> findAllTodo();

}
