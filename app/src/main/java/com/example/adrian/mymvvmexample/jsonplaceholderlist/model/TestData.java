package com.example.adrian.mymvvmexample.jsonplaceholderlist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/27/2017.
 */

public final class TestData {

    public static List<DataModel> getDataModelList() {
        DataModel dataModel1 = new DataModel("ONE");
        DataModel dataModel2 = new DataModel("TWO");
        DataModel dataModel3 = new DataModel("THREE");
        List<DataModel> list = new ArrayList<>();
        list.add(dataModel1);
        list.add(dataModel2);
        list.add(dataModel3);
        return list;
    }

    public static List<String> getTitles() {
        List<String> list = new ArrayList<>();
        list.add("Title-1");
        list.add("Title-2");
        list.add("Title-3");
        return list;
    }

}
