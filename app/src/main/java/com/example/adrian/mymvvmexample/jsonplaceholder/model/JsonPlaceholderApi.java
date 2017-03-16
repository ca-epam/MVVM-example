package com.example.adrian.mymvvmexample.jsonplaceholder.model;

import android.databinding.ObservableField;

/**
 * Created by Adrian_Czigany on 3/14/2017.
 */

public class JsonPlaceholderApi {

    public int id;
    public String text1;
    public ObservableField<String> text2 = new ObservableField<>();

    public JsonPlaceholderApi(int id, String text1, String text2) {
        this.id = id;
        this.text1 = text1;
        this.text2.set(text2);
    }

}
