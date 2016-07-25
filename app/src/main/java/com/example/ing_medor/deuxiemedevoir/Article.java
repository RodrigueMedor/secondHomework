package com.example.ing_medor.deuxiemedevoir;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.transform.sax.SAXResult;

/**
 * Created by ING-Medor on 7/24/2016.
 */
public class Article implements Serializable{
    String webUrl;

    public String getHeadline() {
        return headline;
    }

    public String getTumbNail() {
        return tumbNail;
    }

    public String getWebUrl() {
        return webUrl;
    }

    String headline;
    String tumbNail;

    public Article(JSONObject jsonObject){
        try{
            this.webUrl = jsonObject.getString("web_url");
            this.headline = jsonObject.getJSONObject("headline").getString("main");
            JSONArray multimedia = jsonObject.getJSONArray("multimedia");
            if(multimedia.length() > 0){
                JSONObject multimediaJson = multimedia.getJSONObject(0);
                this.tumbNail = "http://www.nytimescom/"+ multimediaJson.getString("url");
            }else {
                this.tumbNail = "";
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Article> fromJSONArray(JSONArray array){
        ArrayList<Article> results = new ArrayList<>();
         for(int x = 0; x < array.length(); x++){
             try {
                 results.add(new Article(array.getJSONObject(x)));
             }catch (JSONException e){
                 e.printStackTrace();
             }
         }
        return  results;
    }
}
