package com.example.mynews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallableInterface {
    @GET("sections")
    Call<NewsModel> getData(@Query("api-key") String key);
}
