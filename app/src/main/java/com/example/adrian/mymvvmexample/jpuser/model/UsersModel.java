package com.example.adrian.mymvvmexample.jpuser.model;

import com.example.adrian.mymvvmexample.jsonplaceholder.service.UserService;

/**
 * Created by Adrian_Czigany on 3/23/2017.
 */

public class UsersModel {

    private UserService userService;

    public UsersModel(UserService userService) {
        this.userService = userService;
    }
}
