package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityJsonPlaceholderApiBinding;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderApiComponent;

public class JsonPlaceholderApiActivity extends BaseActivity implements JsonPlaceholderApiView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JsonPlaceholderApiComponent.Injector.buildComponent(this).inject(this);

        ActivityJsonPlaceholderApiBinding activityJsonPlaceholderApiBinding = DataBindingUtil.setContentView(this, R.layout.activity_json_placeholder_api);

        JsonPlaceholderApiHandler jsonPlaceholderApiHandler = new JsonPlaceholderApiHandler(this);
        activityJsonPlaceholderApiBinding.setHandler(jsonPlaceholderApiHandler);

    }

}
