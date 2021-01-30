package com.example.mynews;


import java.io.Serializable;

public class Results implements Serializable {

    private String section;

    private String date;

    private String title;

    private String url;
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public Results(String section, String date, String title, String url, String author) {
        this.section = section;
        this.date = date;
        this.title = title;
        this.url = url;
        this.author = author;

    }
}