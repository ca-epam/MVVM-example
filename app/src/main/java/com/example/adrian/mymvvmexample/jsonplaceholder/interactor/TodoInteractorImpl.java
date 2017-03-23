package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Todo;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.TodoService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class TodoInteractorImpl implements TodoInteractor {
    private static final String TAG = TodoInteractorImpl.class.getName();

    private Observer<List<Todo>> todoListObserver;
    private Observer<Todo> todoObserver;

    private TodoService todoService;

    public TodoInteractorImpl(TodoService todoService) {
        this.todoService = todoService;

        createTodoListObserver();
        createTodoObserver();

    }

    private void createTodoListObserver() {
        Log.i(TAG, "createTodoListObserver ...");

        todoListObserver = new Observer<List<Todo>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(List<Todo> todos) {
                Log.i(TAG, "onNext");
                Log.i(TAG, todos.toString());
            }
        };
    }

    private void createTodoObserver() {
        Log.i(TAG, "createTodoObserver ...");

        todoObserver = new Observer<Todo>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(Todo todo) {
                Log.i(TAG, "onNext");
                Log.i(TAG, todo.toString());
            }
        };
    }

    @Override
    public void findAllTodo() {
        todoService.findAllTodo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(todoListObserver);
    }

}
