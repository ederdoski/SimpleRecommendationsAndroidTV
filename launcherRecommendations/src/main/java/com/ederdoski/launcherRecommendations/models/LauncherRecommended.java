package com.ederdoski.launcherRecommendations.models;

import android.os.Parcel;
import android.os.Parcelable;

public class LauncherRecommended implements Parcelable {

    private String id;
    private String title;
    private String description;
    private String imageUrl;

    public LauncherRecommended(Parcel source) {
        id = source.readString();
        title = source.readString();
        description = source.readString();
        imageUrl = source.readString();
    }

    public LauncherRecommended(String id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public static final Creator<LauncherRecommended> CREATOR = new Creator<LauncherRecommended>() {
        @Override
        public LauncherRecommended createFromParcel(Parcel in) {
            return new LauncherRecommended(in);
        }

        @Override
        public LauncherRecommended[] newArray(int size) {
            return new LauncherRecommended[size];
        }
    };

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.imageUrl);
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
}
