package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityJsonPlaceholderApiBinding;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderApiComponent;

public class JsonPlaceholderApiActivity extends BaseActivity implements JsonPlaceholderApiView {

//    @BindView(R.id.btnOpenJsonPlaceholderApiList)
//    Button btnOpenJsonPlaceholderApiList;
//
//    @BindView(R.id.btnFindAllPost)
//    Button btnFindAllPost;
//
//    @BindView(R.id.btnPostById)
//    Button btnPostById;
//
//    @BindView(R.id.btnFindAllComment)
//    Button btnFindAllComment;
//
//    @BindView(R.id.btnFindAllAlbum)
//    Button btnFindAllAlbum;
//
//    @BindView(R.id.btnFindAllPhoto)
//    Button btnFindAllPhoto;
//
//    @BindView(R.id.btnFindAllTodo)
//    Button btnFindAllTodo;
//
//    @BindView(R.id.btnFindAllUser)
//    Button btnFindAll;

//    @Inject
//    JsonPlaceholderApiPresenter jsonPlaceholderApiPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ButterKnife.bind(this);
        JsonPlaceholderApiComponent.Injector.buildComponent(this).inject(this);

        ActivityJsonPlaceholderApiBinding activityJsonPlaceholderApiBinding = DataBindingUtil.setContentView(this, R.layout.activity_json_placeholder_api);

        JsonPlaceholderApiHandler jsonPlaceholderApiHandler = new JsonPlaceholderApiHandler();
        activityJsonPlaceholderApiBinding.setHandler(jsonPlaceholderApiHandler);

    }

//    @OnClick(R.id.btnOpenJsonPlaceholderApiList)
//    public void onClickBtnOpenJsonPlaceholderApiList() {
//        Intent intent = new Intent(JsonPlaceholderApiActivity.this, JsonPlaceholderApiListActivity.class);
//        startActivity(intent);
//    }
//
//    @OnClick(R.id.btnFindAllPost)
//    public void onClickBtnFindAllPost() {
//        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllPost();
//    }
//
//    @OnClick(R.id.btnPostById)
//    public void onClickBtnPostById() {
//        jsonPlaceholderApiPresenterImpl.onClickBtnPostById(1);
//    }
//
//    @OnClick(R.id.btnFindAllComment)
//    public void onClickBtnFindAllComment() {
//        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllComment();
//    }
//
//    @OnClick(R.id.btnFindAllAlbum)
//    public void onClickBtnFindAllAlbum() {
//        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllAlbum();
//    }
//
//    @OnClick(R.id.btnFindAllPhoto)
//    public void onClickBtnFindAllPhoto() {
//        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllAlbum();
//    }
//
//    @OnClick(R.id.btnFindAllTodo)
//    public void onClickBtnFindAllTodo() {
//        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllTodo();
//    }
//
//    @OnClick(R.id.btnFindAllUser)
//    public void onClickBtnFindAllUser() {
//        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllUser();
//    }

}
