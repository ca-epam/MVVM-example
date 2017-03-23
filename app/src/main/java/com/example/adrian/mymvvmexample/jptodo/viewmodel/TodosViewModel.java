package com.example.adrian.mymvvmexample.jptodo.viewmodel;

import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jptodo.model.TodosModel;
import com.example.adrian.mymvvmexample.jptodo.view.TodosActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class TodosViewModel extends BaseViewModel<TodosActivity> implements TodosModel.OnTodosCallback {

    private TodosModel todosModel;

    private List<TodoItemViewModel> todoItemViewModels = new ArrayList<>();

    private int todoItemLayoutId = R.layout.list_item_todo;

    private int variableId = BR.todoItemVM;

    public TodosViewModel(TodosActivity activity, TodosModel todosModel) {
        super(activity);
        this.todosModel = todosModel;

        init();
    }

    private void init() {
        getActivity().getBinding().rvTodos.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        todosModel.findAllTodo();
    }


    @Override
    public void onStart() {
        super.onStart();
        todosModel.registerCallback(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        todosModel.unRegisterCallback();
    }

    @Bindable
    public List<TodoItemViewModel> getTodoItemViewModels() {
        return todoItemViewModels;
    }

    public void setTodoItemViewModels(List<TodoItemViewModel> todoItemViewModels) {
        this.todoItemViewModels = todoItemViewModels;
        notifyPropertyChanged(BR.todoItemViewModels);
    }

    @Bindable
    public int getTodoItemLayoutId() {
        return todoItemLayoutId;
    }

    @Bindable
    public int getVariableId() {
        return variableId;
    }

    private List<TodoItemViewModel> convertToViewModel(List<Todo> todos) {
        List<TodoItemViewModel> todoItemViewModels = new ArrayList<>();
        for (Todo t : todos) {
            todoItemViewModels.add(new TodoItemViewModel(t));
        }
        return todoItemViewModels;
    }

    @Override
    public void onFindAllTodoSuccess(List<Todo> todos) {
        setTodoItemViewModels(convertToViewModel(todos));
    }

    @Override
    public void onFindAllTodoError(Throwable t) {
        t.printStackTrace();
    }
}
