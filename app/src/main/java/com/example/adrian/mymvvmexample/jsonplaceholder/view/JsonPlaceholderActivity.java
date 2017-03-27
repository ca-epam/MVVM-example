package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.os.Bundle;
import android.widget.Button;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderComponent;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JsonPlaceholderActivity extends BaseActivity implements JsonPlaceholderView {

    private static final String TAG = JsonPlaceholderActivity.class.getName();

    @BindView(R.id.btnFindAllPost)
    Button btnFindAllPost;

    @Inject
    JsonPlaceholderPresenter jsonPlaceholderPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_placeholder);

        ButterKnife.bind(this);

        JsonPlaceholderComponent.Injector.buildComponent(this).inject(this);
    }

    @OnClick(R.id.btnOpenJsonPlaceholderList)
    public void onClickBtnOpenJsonPlaceholderList() {
        jsonPlaceholderPresenter.onClickBtnOpenJsonPlaceholderList();
    }

    @OnClick(R.id.btnFindAllPost)
    public void onClickBtnFindAllPost() {
        jsonPlaceholderPresenter.onClickBtnFindAllPost();
    }

    @OnClick(R.id.btnFindAllComment)
    public void onClickBtnFindAllComment() {
        jsonPlaceholderPresenter.onClickBtnFindAllComment();
    }

    @OnClick(R.id.btnFindAllAlbum)
    public void onClickBtnFindAllAlbum() {
        jsonPlaceholderPresenter.onClickBtnFindAllAlbum();
    }

    @OnClick(R.id.btnFindAllPhoto)
    public void onClickBtnFindAllPhoto() {
        jsonPlaceholderPresenter.onClickBtnFindAllPhoto();
    }

    @OnClick(R.id.btnFindAllTodo)
    public void onClickBtnFindAllTodo() {
        jsonPlaceholderPresenter.onClickBtnFindAllTodo();
    }

    @OnClick(R.id.btnFindAllUser)
    public void onClickBtnFindAllUser() {
        jsonPlaceholderPresenter.onClickBtnFindAllUser();
    }




}
