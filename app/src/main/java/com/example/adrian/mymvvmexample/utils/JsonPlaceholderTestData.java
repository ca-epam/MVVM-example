package com.example.adrian.mymvvmexample.utils;

import com.example.adrian.mymvvmexample.jsonplaceholder.viewmodel.JsonPlaceholder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class JsonPlaceholderTestData {

    public static List<JsonPlaceholder> get() {
        List<JsonPlaceholder> list = new ArrayList<>();
        for(int i=0; i<15; i++) {
            list.add(new JsonPlaceholder(i+1, "data" + i+1, "text" + i+1));
        }
        return list;
    }

}
