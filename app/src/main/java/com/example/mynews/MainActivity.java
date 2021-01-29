package com.example.mynews;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.loader.content.Loader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements androidx.loader.app.LoaderManager.LoaderCallbacks<ArrayList<Results>> {
    ArrayList<Results> results;
    public   static final String GUARDIAN_REQUEST_URL =
            "http://content.guardianapis.com/search?q=debates&api-key=e28f4de4-285b-4ea8-bc6f-0a8175543863";
    private static final int NEWS_LOADER_ID = 1;
    private static final String TAG = "MainActivity";

    ListView mListView;
    TextView mTextView;
    CustomAdapter mAdapter;
    ProgressBar mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        mListView = (ListView) findViewById(R.id.list_view);
        mProgressBar = (ProgressBar) findViewById(R.id.progres);
        mTextView = (TextView) findViewById(R.id.text_view);

        if (networkInfo != null && networkInfo.isConnected()) {
          android.app.LoaderManager loaderManager=getLoaderManager();
          loaderManager.getLoader(NEWS_LOADER_ID);

        } else {
            mProgressBar.setVisibility(View.GONE);
            mTextView.setVisibility(View.VISIBLE);
            mTextView.setText(R.string.no_internet_text);
        }
    }
    NewsModel newsModel = new NewsModel();

    @NonNull
    @Override
    public Loader<ArrayList<Results>> onCreateLoader(int id, @Nullable Bundle args) {
        return new NewsLoader(this, GUARDIAN_REQUEST_URL);

    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Results>> loader, ArrayList<Results> results) {
        mAdapter = new CustomAdapter(this, results);
        mProgressBar.setVisibility(View.GONE);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Results>> loader) {

    }
}