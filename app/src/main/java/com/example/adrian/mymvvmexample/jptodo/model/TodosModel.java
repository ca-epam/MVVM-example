package com.example.adrian.mymvvmexample.jptodo.model;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Todo;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.TodoService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class TodosModel {


    private static final String TAG = TodosModel.class.getName();

    private final TodoService todoService;

    private Observer<List<Todo>> todoListObserver;

    private Observer<Todo> todoObserver;

    private OnTodosCallback callback;

    public TodosModel(TodoService todoService) {
        this.todoService = todoService;

        createTodoListObserver();
        createTodoObserver();

    }

    private void createTodoListObserver() {
        todoListObserver = new Observer<List<Todo>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllTodoError(e);
            }

            @Override
            public void onNext(List<Todo> todos) {
                Log.i(TAG, "onNext");
                Log.i(TAG, todos.toString());
                callback.onFindAllTodoSuccess(todos);
            }
        };
    }

    private void createTodoObserver() {
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

    public void findAllTodo() {
        todoService.findAllTodo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(todoListObserver);
    }

    public void registerCallback(OnTodosCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnTodosCallback {

        void onFindAllTodoSuccess(List<Todo> todos);

        void onFindAllTodoError(Throwable t);

    }
}
