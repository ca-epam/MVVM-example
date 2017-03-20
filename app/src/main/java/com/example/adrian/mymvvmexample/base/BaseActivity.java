package com.example.adrian.mymvvmexample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.di.BaseComponent;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    private boolean injected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (!injected) {
            inject();
        }

    }

    protected void inject() {
        BaseComponent.Injector.buildComponent(this).inject(this);
        injected = true;
    }

}
