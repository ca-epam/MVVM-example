package com.example.adrian.mymvvmexample.omdb.di;

import com.example.adrian.mymvvmexample.omdb.presenter.OmdbInteractor;
import com.example.adrian.mymvvmexample.omdb.presenter.OmdbInteractorImpl;
import com.example.adrian.mymvvmexample.omdb.presenter.OmdbPresenter;
import com.example.adrian.mymvvmexample.omdb.presenter.OmdbPresenterImpl;
import com.example.adrian.mymvvmexample.omdb.service.OmdbApiService;
import com.example.adrian.mymvvmexample.omdb.view.OmdbApiActivity;
import com.example.adrian.mymvvmexample.omdb.view.OmdbApiView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

@Module
public class OmdbModule {

    private OmdbApiActivity omdbApiActivity;

    private OmdbInteractor omdbInteractor;

    public OmdbModule(OmdbApiActivity omdbApiActivity) {
        this.omdbApiActivity = omdbApiActivity;
    }

    public OmdbModule(OmdbInteractor omdbInteractor) {
        this.omdbInteractor = omdbInteractor;
    }

    @Provides
    @OmdbScope
    public OmdbApiService provideOmdbService(@Named("omdbapi") Retrofit retrofit) {
        OmdbApiService omdbApiService = retrofit.create(OmdbApiService.class);
        return omdbApiService;
    }

    @Provides
    @OmdbScope
    OmdbInteractor provideOmdbInteractor() {
        return new OmdbInteractorImpl(provideOmdApiView());
    }

    @Provides
    @OmdbScope
    public OmdbPresenter provideOmdbPresenter() {
        return new OmdbPresenterImpl(provideOmdApiView(), provideOmdbInteractor());
    }

    @Provides
    @OmdbScope
    OmdbApiView provideOmdApiView() {
        return omdbApiActivity;
    }

}
