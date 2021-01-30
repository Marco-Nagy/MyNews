package com.example.mynews;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

public class NewsLoader extends AsyncTaskLoader<ArrayList<Results>> {
    public String url;

    public NewsLoader(@NonNull Context context, String url) {
        super(context);
        this.url = url;
    }

    @Nullable
    @Override
    public ArrayList<Results> loadInBackground() {
        if (url == null) {

        }
        return Query.fetchNewsData(url);
    }
}
