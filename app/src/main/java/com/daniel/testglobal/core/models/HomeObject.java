package com.daniel.testglobal.core.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class HomeObject implements Parcelable {

    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.image);
    }

    public HomeObject() {
    }

    protected HomeObject(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<HomeObject> CREATOR = new Parcelable.Creator<HomeObject>() {
        @Override
        public HomeObject createFromParcel(Parcel source) {
            return new HomeObject(source);
        }

        @Override
        public HomeObject[] newArray(int size) {
            return new HomeObject[size];
        }
    };
}
