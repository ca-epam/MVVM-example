package com.example.adrian.mymvvmexample.jpphoto.model;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Photo;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Post;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PhotoService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class PhotosModel {

    private static final String TAG = PhotosModel.class.getName();

    private final PhotoService photoService;

    private Observer<List<Photo>> photoListObserver;

    private Observer<Post> postObserver;

    private OnPhotosCallback callback;

    public PhotosModel(PhotoService photoService) {
        this.photoService = photoService;

        createPhotoListObserver();
        createPhotoObserver();

    }

    private void createPhotoListObserver() {
        photoListObserver = new Observer<List<Photo>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllPhotoError(e);
            }

            @Override
            public void onNext(List<Photo> photos) {
                Log.i(TAG, "onNext");
                Log.i(TAG, photos.toString());
                callback.onFindAllPhotoSuccess(photos);
            }
        };
    }

    private void createPhotoObserver() {
        postObserver = new Observer<Post>() {
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
            public void onNext(Post post) {
                Log.i(TAG, "onNext");
                Log.i(TAG, post.toString());
            }
        };
    }

    public void findAllPost() {
        photoService.findAllPhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photoListObserver);
    }

    public void registerCallback(OnPhotosCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnPhotosCallback {

        void onFindAllPhotoSuccess(List<Photo> photos);

        void onFindAllPhotoError(Throwable t);

    }

}
