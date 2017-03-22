package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.viewmodel.JsonPlaceholder;
import com.example.adrian.mymvvmexample.utils.JsonPlaceholderTestData;

import java.util.List;

public class JsonPlaceholderListActivity extends BaseActivity {

    private static final String TAG = JsonPlaceholderListActivity.class.getName();

    private RecyclerView rvJsonPlaceHolder;

    private JsonPlaceholderAdapter jsonPlaceholderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_placeholder_list);

        rvJsonPlaceHolder = (RecyclerView) findViewById(R.id.rvJsonPlaceHolder);
        rvJsonPlaceHolder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        updateUI();

    }

    private void updateUI() {
        List<JsonPlaceholder> list = JsonPlaceholderTestData.get();
        if(jsonPlaceholderAdapter == null) {
            jsonPlaceholderAdapter = new JsonPlaceholderAdapter(list);
        }
        rvJsonPlaceHolder.setAdapter(jsonPlaceholderAdapter);
    }

}
