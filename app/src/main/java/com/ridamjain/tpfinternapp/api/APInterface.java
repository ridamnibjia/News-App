package com.ridamjain.tpfinternapp.api;

import com.ridamjain.tpfinternapp.models.Article;
import com.ridamjain.tpfinternapp.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APInterface {
    @GET("top-headlines")
    Call<News> getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
