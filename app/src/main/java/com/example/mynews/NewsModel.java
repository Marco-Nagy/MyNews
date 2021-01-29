package com.example.mynews;


import java.io.Serializable;
import java.util.ArrayList;


public class NewsModel implements Serializable {



    private ArrayList<Results> results;
    public ArrayList<Results> getResults(){
        return results;
    }
}
 class Results {

     private String sectionName;

     private String webPublicationDate;

     private String webTitle;

     private String webUrl;

     public Results(String sectionName, String webPublicationDate, String webTitle, String webUrl) {
         this.sectionName = sectionName;
         this.webPublicationDate = webPublicationDate;
         this.webTitle = webTitle;
         this.webUrl = webUrl;
     }

     public String getSectionName() {
         return sectionName;
     }

     public String getWebPublicationDate() {
         return webPublicationDate;
     }

     public String getWebTitle() {
         return webTitle;
     }

     public String getWebUrl() {
         return webUrl;
     }
 }
