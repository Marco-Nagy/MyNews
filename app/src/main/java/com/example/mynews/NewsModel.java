package com.example.mynews;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class NewsModel {
    private ArrayList<Articles> articles;
    public ArrayList<Articles>getArticles(){
        return articles;
    }
}
class Articles {
    private String webTitle;
    private String webUrl;
    private String sectionName;
    private String webPublicationDate;

    public Articles(String webTitle, String webUrl, String sectionName, String webPublicationDate) {
        this.webTitle = webTitle;
        this.webUrl = webUrl;
        this.sectionName = sectionName;
        this.webPublicationDate = webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }
}
