package com.example.adrian.mymvvmexample.jpphoto.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpphoto.view.PhotosActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {PhotosModule.class})
public interface PhotosComponent {

    void inject(PhotosActivity photosActivity);

    final class Injector {
        private Injector() {
        }

        public static PhotosComponent buildComponent(PhotosActivity activity) {
            return DaggerPhotosComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .photosModule(new PhotosModule(activity))
                    .build();
        }
    }

}
