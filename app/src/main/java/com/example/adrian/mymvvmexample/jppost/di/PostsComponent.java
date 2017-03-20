package com.example.adrian.mymvvmexample.jppost.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jppost.view.PostsActivity;
import com.example.adrian.mymvvmexample.jppost.viewmodel.PostsViewModel;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 16..
 */

@Component(dependencies = AppComponent.class, modules = {PostsModule.class})
@ActivityScope
public interface PostsComponent {

    void inject(PostsViewModel postsViewModel);

    void inject(PostsActivity postsActivity);

    final class Injector {
        private Injector() {
        }

        public static PostsComponent buildComponent(PostsActivity activity) {
            return DaggerPostsComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .postsModule(new PostsModule(activity))
                    .build();
        }
    }
}
