package com.example.mynews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.Response;

public class NewsModel {

        @SerializedName("response")
        @Expose
        private Response response;

    @SerializedName("")
    private ArrayList<Content> contents;
    public ArrayList<Content> getResponse(){
        return contents;
    }
}
 class Content {

     @SerializedName("id")
     @Expose
     private String id;
     @SerializedName("sectionId")
     @Expose
     private String sectionId;
     @SerializedName("sectionName")
     @Expose
     private String sectionName;
     @SerializedName("webPublicationDate")
     @Expose
     private String webPublicationDate;
     @SerializedName("webTitle")
     @Expose
     private String webTitle;
     @SerializedName("webUrl")
     @Expose
     private String webUrl;

     public Content(String id, String sectionId, String sectionName, String webPublicationDate, String webTitle, String webUrl) {
         this.id = id;
         this.sectionId = sectionId;
         this.sectionName = sectionName;
         this.webPublicationDate = webPublicationDate;
         this.webTitle = webTitle;
         this.webUrl = webUrl;
     }

     public String getId() {
         return id;
     }

     public String getSectionId() {
         return sectionId;
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
