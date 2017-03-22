package com.example.adrian.mymvvmexample.jpalbum.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.jpalbum.model.AlbumsModel;
import com.example.adrian.mymvvmexample.jpalbum.view.AlbumsActivity;
import com.example.adrian.mymvvmexample.jpalbum.viewmodel.AlbumsViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderServiceModule;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.AlbumService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

@Module(includes = {JsonPlaceholderServiceModule.class})
public class AlbumsModule {

    private AlbumsActivity albumsActivity;

    public AlbumsModule(AlbumsActivity albumsActivity) {
        this.albumsActivity = albumsActivity;
    }

    @ActivityScope
    @Provides
    AlbumsActivity providesAlbumsActivity() {
        return this.albumsActivity;
    }

    @ActivityScope
    @Provides
    AlbumsModel providesAlbumsModel(AlbumService albumService) {
        return new AlbumsModel(albumService);
    }

    @ActivityScope
    @Provides
    AlbumsViewModel providesAlbumsViewModel(AlbumsActivity albumsActivity, AlbumsModel albumsModel) {
        return new AlbumsViewModel(albumsActivity, albumsModel);
    }
}
