package com.example.adrian.mymvvmexample.main.di;

import com.example.adrian.mymvvmexample.base.di.ActivityScope;
import com.example.adrian.mymvvmexample.main.presenter.MainPresenter;
import com.example.adrian.mymvvmexample.main.presenter.MainPresenterImpl;
import com.example.adrian.mymvvmexample.main.view.MainActivity;
import com.example.adrian.mymvvmexample.main.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 03. 06..
 */

@Module
public class MainModule {

    private MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter() {
        return new MainPresenterImpl(provideMainView());
    }

    @Provides
    @ActivityScope
    MainView provideMainView() {
        return mainActivity;
    }
}
