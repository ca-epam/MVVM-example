package com.example.adrian.mymvvmexample.jpphoto.viewmodel;

import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jpphoto.model.PhotosModel;
import com.example.adrian.mymvvmexample.jpphoto.view.PhotosActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class PhotosViewModel extends BaseViewModel<PhotosActivity> implements PhotosModel.OnPhotosCallback {

    private PhotosModel photosModel;

    private List<PhotoItemViewModel> photoItemViewModels = new ArrayList<>();

    private int photoItemLayoutId = R.layout.list_item_photo;

    private int variableId = BR.photoItemVM;

    public PhotosViewModel(PhotosActivity activity, PhotosModel photosModel) {
        super(activity);
        this.photosModel = photosModel;

        init();
    }

    private void init() {
        getActivity().getBinding().rvPhotos.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        photosModel.findAllPost();
    }

    @Override
    public void onStart() {
        super.onStart();
        photosModel.registerCallback(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        photosModel.unRegisterCallback();
    }

    private List<PhotoItemViewModel> convertToViewModel(List<Photo> photos) {
        List<PhotoItemViewModel> photoItemViewModels = new ArrayList<>();
        for (Photo p : photos) {
            photoItemViewModels.add(new PhotoItemViewModel(p));
        }
        return photoItemViewModels;
    }

    @Override
    public void onFindAllPhotoSuccess(List<Photo> photos) {
        setPhotoItemViewModels(convertToViewModel(photos));
    }

    @Override
    public void onFindAllPhotoError(Throwable t) {
        t.printStackTrace();
    }

    @Bindable
    public List<PhotoItemViewModel> getPhotoItemViewModels() {
        return photoItemViewModels;
    }

    public void setPhotoItemViewModels(List<PhotoItemViewModel> photoItemViewModels) {
        this.photoItemViewModels = photoItemViewModels;
        notifyPropertyChanged(BR.photoItemViewModels);
    }

    @Bindable
    public int getPhotoItemLayoutId() {
        return photoItemLayoutId;
    }

    @Bindable
    public int getVariableId() {
        return variableId;
    }
}
