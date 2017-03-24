package com.example.adrian.mymvvmexample.base;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public abstract class BaseViewModel<A extends BaseActivity> extends BaseObservable {

    protected A activity;

    public BaseViewModel(A activity) {
        this.activity = activity;
    }

    public A getActivity() {
        return activity;
    }

    public void finish() {
        activity.finish();
    }

    /*
     * Activity lifecycle
     */

    public boolean onBackKeyPress() {
        return false;
    }

    public void onStart() {
        //Override me!
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Override me!
    }

    public void onPause() {
        //Override me!
    }

    public void onResume() {
        //Override me!
    }

    public void onStop() {
        //Override me!
    }

    public void onDestroy() {
        //Override me!
    }

    public void onCreateOptionsMenu(Menu menu) {
        //Override me!
    }

    public void onOptionsItemSelected(MenuItem item) {
        //Override me!
    }

}
