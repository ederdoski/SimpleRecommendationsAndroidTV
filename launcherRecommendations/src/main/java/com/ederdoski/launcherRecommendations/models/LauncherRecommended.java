package com.ederdoski.launcherRecommendations.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class LauncherRecommended implements Serializable {

    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private String extra;
    private ArrayList<String> arrayExtra;

    public LauncherRecommended(String id, String title, String description, String imageUrl, String extra, ArrayList<String> arrayExtra) {
        this.id          = id;
        this.title       = title;
        this.description = description;
        this.imageUrl    = imageUrl;
        this.extra       = extra;
        this.arrayExtra  = arrayExtra;
    }

    public LauncherRecommended(String id, String title, String description, String imageUrl, String extra) {
        this.id          = id;
        this.title       = title;
        this.description = description;
        this.imageUrl    = imageUrl;
        this.extra       = extra;
    }

    public LauncherRecommended(String id, String title, String description, String imageUrl) {
        this.id          = id;
        this.title       = title;
        this.description = description;
        this.imageUrl    = imageUrl;
        this.extra       = extra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public ArrayList<String> getArrayExtra() {
        return arrayExtra;
    }

    public void setArrayExtra(ArrayList<String> arrayExtra) {
        this.arrayExtra = arrayExtra;
    }
}
