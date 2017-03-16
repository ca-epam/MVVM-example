package com.example.adrian.mymvvmexample.jsonplaceholder.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by Adrian_Czigany on 3/14/2017.
 */

public class JsonPlaceholder {

    public int id;
    public String text1;
    public ObservableField<String> text2 = new ObservableField<>();

    public JsonPlaceholder(int id, String text1, String text2) {
        this.id = id;
        this.text1 = text1;
        this.text2.set(text2);
    }

}
