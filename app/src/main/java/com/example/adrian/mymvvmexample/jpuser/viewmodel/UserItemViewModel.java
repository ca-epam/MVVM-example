package com.example.adrian.mymvvmexample.jpuser.viewmodel;

import android.databinding.Bindable;

import com.example.adrian.mymvvmexample.BR;
import com.example.adrian.mymvvmexample.common.ListItemViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Address;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Company;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.User;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class UserItemViewModel extends ListItemViewModel {

    private User user;

    public UserItemViewModel(User user) {
        this.user = user;
    }

    @Bindable
    public Integer getId() {
        return this.user.getId();
    }

    @Bindable
    public String getName() {
        return this.user.getName();
    }

    @Bindable
    public String getUsername() {
        return this.user.getUsername();
    }

    @Bindable
    public String getEmail() {
        return this.user.getEmail();
    }

    @Bindable
    public Address getAddress() {
        return this.user.getAddress();
    }

    @Bindable
    public String getPhone() {
        return this.user.getPhone();
    }

    @Bindable
    public String getWebsite() {
        return this.user.getWebsite();
    }

    @Bindable
    public Company getCompany() {
        return this.user.getCompany();
    }

    public void setId(Integer id) {
        this.user.setId(id);
        notifyPropertyChanged(BR.id);
    }

    public void setUsername(String username) {
        this.user.setUsername(username);
        notifyPropertyChanged(BR.username);
    }

    public void setEmail(String email) {
        this.user.setEmail(email);
        notifyPropertyChanged(BR.email);
    }

    public void setAddress(Address address) {
        this.user.setAddress(address);
        notifyPropertyChanged(BR.address);
    }

    public void setPhone(String phone) {
        this.user.setPhone(phone);
        notifyPropertyChanged(BR.phone);
    }

    public void setWebsite(String website) {
        this.user.setWebsite(website);
        notifyPropertyChanged(BR.website);
    }

    public void setCompany(Company company) {
        this.user.setCompany(company);
        notifyPropertyChanged(BR.company);
    }

}
