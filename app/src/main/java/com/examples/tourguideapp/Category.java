package com.examples.tourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
    private int imageId;
    private String name,descr,number,link,loc,timing;
    public Category(int i,String n,String d,String num,String l,String map,String t){
        imageId = i;
        name = n;
        descr = d;
        number = num;
        link = l;
        loc = map;
        timing = t;
    }
    public Category(int i,String n,String d){
        imageId = i;
        name = n;
        descr = d;
    }
    public Category(Parcel source) {
        imageId= source.readInt();
        name = source.readString();
        descr = source.readString();
            number = source.readString();
            link = source.readString();
            loc = source.readString();
            timing = source.readString();

    }

    public int getImageId(){
        return imageId;
    }

    public String getDescr() {
        return descr;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getLoc() {
        return loc;
    }

    public String getNumber() {
        return number;
    }

    public String getTiming() {
        return timing;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageId);
        parcel.writeString(name);
        parcel.writeString(descr);
            parcel.writeString(number);
            parcel.writeString(link);
            parcel.writeString(loc);
            parcel.writeString(timing);

    }
    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }

        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }
    };
}
