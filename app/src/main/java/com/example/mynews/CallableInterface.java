package com.example.mynews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CallableInterface {
    @GET("sections")
    Call<NewsModel> getData();
}
