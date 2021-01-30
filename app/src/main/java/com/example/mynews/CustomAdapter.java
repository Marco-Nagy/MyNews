package com.example.mynews;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Results> results;

    public CustomAdapter(Activity activity, ArrayList<Results> results) {
        this.activity = activity;
        this.results = results;
    }
    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = activity.getLayoutInflater().inflate(R.layout.list_item, parent, false);
        TextView tvTitle = view.findViewById(R.id.text_title);
        TextView tvSection = view.findViewById(R.id.text_section);
        TextView tvDate = view.findViewById(R.id.text_PublicationDate);
        TextView tvAuthor = view.findViewById(R.id.text_author);
        tvTitle.setText(results.get(position).getTitle().substring(0, 40) + " ...");
        tvSection.setText(results.get(position).getSection());
        tvDate.setText(results.get(position).getDate());
        tvAuthor.setText(results.get(position).getAuthor());

        return view;
    }
}