package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Album;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.AlbumService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class AlbumInteractorImpl implements AlbumInteractor {

    private static final String TAG = AlbumInteractorImpl.class.getName();

    private AlbumService albumService;

    public AlbumInteractorImpl(AlbumService albumService) {
        this.albumService = albumService;

    }

    @Override
    public void findAllAlbum() {
        Call<List<Album>> call = albumService.findAllAlbum();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                List<Album> albums = response.body();
                Log.i(TAG, albums.toString());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }
}
