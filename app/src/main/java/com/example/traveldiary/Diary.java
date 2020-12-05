package com.example.traveldiary;

public class Diary {
    String name;
    String description;
    String latitude;
    String longitude;

    public Diary(String name, String description, String latitude, String longitude) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
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
}
