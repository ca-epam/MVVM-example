package com.example.adrian.mymvvmexample.jptodo.viewmodel;

import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.common.ListItemViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Todo;

/**
 * Created by Adrian_Czigany on 3/23/2017.
 */

public class TodoItemViewModel extends ListItemViewModel {

    private Todo todo;

    public TodoItemViewModel(Todo todo) {
        this.todo = todo;
    }

    @Bindable
    public Integer getUserId() {
        return this.todo.getUserId();
    }

    @Bindable
    public Integer getId() {
        return this.todo.getId();
    }

    @Bindable
    public String getTitle() {
        return this.todo.getTitle();
    }

    @Bindable
    public boolean getCompleted() {
        return this.todo.getCompleted();
    }

    public void setUserId(Integer userId) {
        this.todo.setUserId(userId);
        notifyPropertyChanged(BR.userId);
    }

    public void setId(Integer id) {
        this.todo.setUserId(id);
        notifyPropertyChanged(BR.id);
    }

    public void setTitle(String title) {
        this.todo.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    public void setCompleted(boolean completed) {
        this.todo.setCompleted(completed);
        notifyPropertyChanged(BR.completed);
    }

    @Override
    public String toString() {
        return "TodoItemViewModel{" +
                "todo=" + todo +
                '}';
    }
}
