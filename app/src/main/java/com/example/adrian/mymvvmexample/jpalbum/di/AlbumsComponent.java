package com.example.adrian.mymvvmexample.jpalbum.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpalbum.view.AlbumsActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {AlbumsModule.class})
public interface AlbumsComponent {

    void inject(AlbumsActivity albumsActivity);

    final class Injector {
        private Injector() {
        }

        public static AlbumsComponent buildComponent(AlbumsActivity activity) {
            return DaggerAlbumsComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .albumsModule(new AlbumsModule(activity))
                    .build();
        }
    }

}
