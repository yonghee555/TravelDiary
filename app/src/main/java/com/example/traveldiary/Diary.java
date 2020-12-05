package com.example.traveldiary;

public class Diary {
    String name;
    String description;
    String latitude;
    String longitude;
    byte[] img;

    public Diary(String name, String description, String latitude, String longitude, byte[] img) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.img = img;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public byte[] getImg() {
        return img;
    }
}
