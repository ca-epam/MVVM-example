package com.example.adrian.mymvvmexample.jppost.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jppost.view.PostActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/24/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {PostModule.class})
public interface PostComponent {

    void inject(PostActivity postActivity);

    final class Injector {
        private Injector() {
        }

        public static PostComponent buildComponent(PostActivity activity) {
            return DaggerPostComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .postModule(new PostModule(activity))
                    .build();
        }
    }

}
