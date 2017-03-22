package com.example.adrian.mymvvmexample.jptodo.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jptodo.view.TodosActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {TodosModule.class})
public interface TodosComponent {

    void inject(TodosActivity todosActivity);

    final class Injector {
        private Injector() {
        }

        public static TodosComponent buildComponent(TodosActivity activity) {
            return DaggerTodosComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .todosModule(new TodosModule(activity))
                    .build();
        }
    }

}
