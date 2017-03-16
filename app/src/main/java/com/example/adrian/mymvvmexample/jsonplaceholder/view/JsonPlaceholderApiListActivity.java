package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.jsonplaceholder.viewmodel.JsonPlaceholder;
import com.example.adrian.mymvvmexample.utils.JsonPlaceholderTestData;

import java.util.List;

public class JsonPlaceholderApiListActivity extends AppCompatActivity {

    private static final String TAG = JsonPlaceholderApiListActivity.class.getName();

    private RecyclerView rvJsonPlaceHolder;

    private JsonPlaceholderApiAdapter jsonPlaceholderApiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_placeholder_api_list);

        rvJsonPlaceHolder = (RecyclerView) findViewById(R.id.rvJsonPlaceHolder);
        rvJsonPlaceHolder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        updateUI();

    }

    private void updateUI() {
        List<JsonPlaceholder> list = JsonPlaceholderTestData.get();
        if(jsonPlaceholderApiAdapter == null) {
            jsonPlaceholderApiAdapter = new JsonPlaceholderApiAdapter(list);
        }
        rvJsonPlaceHolder.setAdapter(jsonPlaceholderApiAdapter);
    }

}
