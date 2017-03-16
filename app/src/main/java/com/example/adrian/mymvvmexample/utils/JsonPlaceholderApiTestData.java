package com.example.adrian.mymvvmexample.utils;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.JsonPlaceholderApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class JsonPlaceholderApiTestData {

    public static List<JsonPlaceholderApi> get() {
        List<JsonPlaceholderApi> list = new ArrayList<>();
        for(int i=0; i<15; i++) {
            list.add(new JsonPlaceholderApi(i+1, "data" + i+1, "text" + i+1));
        }
        return list;
    }

}
