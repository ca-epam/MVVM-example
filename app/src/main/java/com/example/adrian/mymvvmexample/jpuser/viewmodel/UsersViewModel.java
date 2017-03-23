package com.example.adrian.mymvvmexample.jpuser.viewmodel;

import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jpuser.model.UsersModel;
import com.example.adrian.mymvvmexample.jpuser.view.UsersActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class UsersViewModel extends BaseViewModel<UsersActivity> implements UsersModel.OnUsersCallback {

    private static final String TAG = UsersViewModel.class.getName();

    private UsersModel usersModel;

    private List<UserItemViewModel> userItemViewModels = new ArrayList<>();

    private int userItemLayoutId = R.layout.list_item_user;

    private int variableId = BR.userItemVM;

    public UsersViewModel(UsersActivity activity, UsersModel usersModel) {
        super(activity);
        this.usersModel = usersModel;

        init();
    }

    private void init() {
        getActivity().getBinding().rvUsers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        usersModel.findAllUser();
    }

    @Override
    public void onStart() {
        super.onStart();
        usersModel.registerCallback(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        usersModel.unRegisterCallback();
    }

    @Bindable
    public List<UserItemViewModel> getUserItemViewModels() {
        return userItemViewModels;
    }

    public void setUserItemViewModels(List<UserItemViewModel> userItemViewModels) {
        this.userItemViewModels = userItemViewModels;
        notifyPropertyChanged(BR.userItemViewModels);
    }

    private List<UserItemViewModel> convertToViewModel(List<User> users) {
        List<UserItemViewModel> userItemViewModels = new ArrayList<>();
        for (User u : users) {
            userItemViewModels.add(new UserItemViewModel(u));
        }
        return userItemViewModels;
    }

    @Override
    public void onFindAllUserSuccess(List<User> users) {
        setUserItemViewModels(convertToViewModel(users));
    }

    @Override
    public void onFindAllUserError(Throwable t) {
        t.printStackTrace();
    }

    @Bindable
    public int getUserItemLayoutId() {
        return userItemLayoutId;
    }

    @Bindable
    public int getVariableId() {
        return variableId;
    }
}
