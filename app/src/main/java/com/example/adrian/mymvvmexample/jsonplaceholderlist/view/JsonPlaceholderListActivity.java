package com.example.adrian.mymvvmexample.jsonplaceholderlist.view;

import android.support.v7.widget.RecyclerView;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BindingActivity;
import com.example.adrian.mymvvmexample.databinding.ActivityJsonPlaceholderListBinding;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.di.JsonPlaceholderListComponent;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.viewmodel.JsonPlaceholderListViewModel;

import javax.inject.Inject;

public class JsonPlaceholderListActivity extends BindingActivity<ActivityJsonPlaceholderListBinding, JsonPlaceholderListViewModel> {

    private static final String TAG = JsonPlaceholderListActivity.class.getName();

    private RecyclerView rvJsonPlaceHolder;

    @Inject
    JsonPlaceholderListViewModel jsonPlaceholderListViewModel;


    @Override
    public JsonPlaceholderListViewModel onCreate() {
        JsonPlaceholderListComponent.Injector.buildComponent(this).inject(this);
        return jsonPlaceholderListViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_json_placeholder_list;
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_json_placeholder_list);
//
//        rvJsonPlaceHolder = (RecyclerView) findViewById(R.id.rvJsonPlaceHolder);
//        rvJsonPlaceHolder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//
//        updateUI();
//    }

//    private void updateUI() {
//        List<JsonPlaceholder> list = JsonPlaceholderTestData.get();
////        if(jsonPlaceholderAdapter == null) {
////            jsonPlaceholderAdapter = new JsonPlaceholderAdapter(list);
////        }
////        rvJsonPlaceHolder.setAdapter(jsonPlaceholderAdapter);
//    }

}
