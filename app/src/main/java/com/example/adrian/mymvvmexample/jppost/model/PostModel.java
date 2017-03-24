package com.example.adrian.mymvvmexample.jppost.model;

import com.example.adrian.mymvvmexample.jsonplaceholder.service.PostService;

/**
 * Created by Adrian_Czigany on 3/24/2017.
 */

public class PostModel {

    private PostService postService;

    public PostModel(PostService postService) {
        this.postService = postService;
    }
}
