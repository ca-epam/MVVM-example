package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Photo;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PhotoService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class PhotoInteractorImpl implements PhotoInteractor {

    private static final String TAG = PhotoInteractorImpl.class.getName();

    private Observer<List<Photo>> photoListObserver;
    private Observer<Photo> photoObserver;


    private PhotoService photoService;

    public PhotoInteractorImpl(PhotoService photoService) {
        this.photoService = photoService;

        createPhotoListObserver();
        createPhotoObserver();
    }

    private void createPhotoListObserver() {
        Log.i(TAG, "createPhotoListObserver ...");

        photoListObserver = new Observer<List<Photo>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(List<Photo> photos) {
                Log.i(TAG, "onNext");
                Log.i(TAG, photos.toString());
            }
        };
    }

    private void createPhotoObserver() {
        Log.i(TAG, "createPhotoObserver ...");

        photoObserver = new Observer<Photo>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(Photo photo) {
                Log.i(TAG, "onNext");
                Log.i(TAG, photo.toString());
            }
        };
    }

    @Override
    public void findAllPhoto() {
        photoService.findAllPhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photoListObserver);
    }



}
