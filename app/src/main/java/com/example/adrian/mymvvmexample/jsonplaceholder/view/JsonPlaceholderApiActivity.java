package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.os.Bundle;
import android.widget.Button;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JsonPlaceholderApiActivity extends BaseActivity implements JsonPlaceholderApiView {

    @BindView(R.id.btnFindAllPost)
    Button btnFindAllPost;

    @Inject
    JsonPlaceholderApiPresenter jsonPlaceholderApiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_placeholder_api);

        ButterKnife.bind(this);


        JsonPlaceholderApiComponent.Injector.buildComponent(this).inject(this);

//        ActivityJsonPlaceholderApiBinding activityJsonPlaceholderApiBinding = DataBindingUtil.setContentView(this, R.layout.activity_json_placeholder_api);



//        JsonPlaceholderApiHandler jsonPlaceholderApiHandler = new JsonPlaceholderApiHandler(this);
//        activityJsonPlaceholderApiBinding.setHandler(jsonPlaceholderApiHandler);

    }

    @OnClick(R.id.btnFindAllPost)
    public void onClickBtnFindAllPost() {
        jsonPlaceholderApiPresenter.onClickBtnFindAllPost();
    }

}
