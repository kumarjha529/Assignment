package com.assignment.own;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetdataService {

    @GET("issues")
    Call<List<storedata>> getAllPhotos();
}