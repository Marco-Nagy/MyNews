package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar pb = findViewById(R.id.progres);
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://content.guardianapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CallableInterface callable = retrofit.create(CallableInterface.class);
        Call<NewsModel> newsModelCall = callable.getData("4c61ebe0-3ed4-4234-ae56-9a5a7afe9bb7");
        newsModelCall.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                pb.setVisibility(View.INVISIBLE);
                NewsModel newsModel = response.body();
                if (newsModel != null && newsModel.getResponse() != null) {
                    Log.d("json", "data" + newsModel.getResponse().get(0).getWebTitle());
                    showListView(newsModel.getResponse());
                }

            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                pb.setVisibility(View.INVISIBLE);
                Log.d("json", "Error" + t.getMessage());

            }
        });
    }

    private void showListView(ArrayList<Content> articles) {
        CustomAdapter adapter = new CustomAdapter(this, articles);
        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            Uri link = Uri.parse(articles.get(position).getWebUrl());
            Intent i = new Intent(Intent.ACTION_VIEW, link);
            startActivity(i);
        });
    }
}