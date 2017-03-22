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
    }

    @OnClick(R.id.btnFindAllPost)
    public void onClickBtnFindAllPost() {
        jsonPlaceholderApiPresenter.onClickBtnFindAllPost();
    }

    @OnClick(R.id.btnFindAllComment)
    public void onClickBtnFindAllComment() {
        jsonPlaceholderApiPresenter.onClickBtnFindAllComment();
    }

    @OnClick(R.id.btnFindAllAlbum)
    public void onClickBtnFindAllAlbum() {
        jsonPlaceholderApiPresenter.onClickBtnFindAllAlbum();
    }

    @OnClick(R.id.btnFindAllPhoto)
    public void onClickBtnFindAllPhoto() {
        jsonPlaceholderApiPresenter.onClickBtnFindAllPhoto();
    }

    @OnClick(R.id.btnFindAllTodo)
    public void onClickBtnFindAllTodo() {
        jsonPlaceholderApiPresenter.onClickBtnFindAllTodo();
    }

    @OnClick(R.id.btnFindAllUser)
    public void onClickBtnFindAllUser() {
        jsonPlaceholderApiPresenter.onClickBtnFindAllUser();
    }

}
