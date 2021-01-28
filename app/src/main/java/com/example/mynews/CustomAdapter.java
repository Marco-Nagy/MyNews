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
    private ArrayList<Articles> articles;

    public CustomAdapter(Activity activity, ArrayList<Articles> articles) {
        this.activity = activity;
        this.articles = articles;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int position) {
        return articles.get(position);
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
        TextView tvAuthor = view.findViewById(R.id.text_PublicationDate);
        tvTitle.setText(articles.get(position).getWebTitle().substring(0, 29) + "...");
        tvSection.setText(articles.get(position).getSectionName());
        tvAuthor.setText(articles.get(position).getWebPublicationDate());

        return view;
    }
}