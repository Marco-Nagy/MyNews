package com.example.mynews;


import java.io.Serializable;

public class Results implements Serializable {

    private String section;

    private String date;

    private String title;

    private String url;

    public Results(String section, String date, String title, String url) {
        this.section = section;
        this.date = date;
        this.title = title;
        this.url = url;
    }

    public String getSection() {
        return section;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}