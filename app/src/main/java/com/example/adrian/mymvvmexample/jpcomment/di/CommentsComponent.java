package com.example.adrian.mymvvmexample.jpcomment.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpcomment.view.CommentsActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {CommentsModule.class})
public interface CommentsComponent {

    void inject(CommentsActivity commentsActivity);

    final class Injector {
        private Injector() {
        }

        public static CommentsComponent buildComponent(CommentsActivity activity) {
            return DaggerCommentsComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .commentsModule(new CommentsModule(activity))
                    .build();
        }
    }

}
