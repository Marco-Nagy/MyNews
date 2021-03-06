package com.example.mynews;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements androidx.loader.app.LoaderManager.LoaderCallbacks<ArrayList<Results>> {
    ArrayList<Results> results;

    String apiKey = "e28f4de4-285b-4ea8-bc6f-0a8175543863";

    String URL =
            "https://content.guardianapis.com/search?&api-key=" + apiKey+"&show-fields=byline";

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
            getSupportLoaderManager().initLoader(NEWS_LOADER_ID, null, this).forceLoad();

        } else {
            mTextView.setVisibility(View.VISIBLE);
            mTextView.setText(R.string.no_internet_text);
            mProgressBar.setVisibility(View.VISIBLE);


        }
    }


    @NonNull
    @Override
    public Loader<ArrayList<Results>> onCreateLoader(int id, @Nullable Bundle args) {
        return new NewsLoader(this, URL);

    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Results>> loader, ArrayList<Results> results) {
        mAdapter = new CustomAdapter(this, results);
        mProgressBar.setVisibility(View.GONE);
        if (mAdapter != null) {
            mListView.setAdapter(mAdapter);
        }
        Log.d("json", "data: " + results.get(0).getUrl());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri link = Uri.parse(results.get(position).getUrl());
                Log.d("json", "data: " + results.get(0).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, link);
                if (intent.resolveActivity(getPackageManager()) != null) {

                    startActivity(intent);  //where intent is your intent
                }
            }
        });

    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Results>> loader) {


    }
}