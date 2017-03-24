package com.example.adrian.mymvvmexample.jptodo.view;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityTodosBinding;
import com.example.adrian.mymvvmexample.jptodo.di.TodosComponent;
import com.example.adrian.mymvvmexample.jptodo.viewmodel.TodosViewModel;

import javax.inject.Inject;

public class TodosActivity extends BindingActivity<ActivityTodosBinding, TodosViewModel> {

    @Inject
    TodosViewModel todosViewModel;


    @Override
    public TodosViewModel onCreate() {
        TodosComponent.Injector.buildComponent(this).inject(this);
        return todosViewModel;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_todos;
    }
}
