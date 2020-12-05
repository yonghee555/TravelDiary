package com.example.traveldiary;

public class Diary {
    String name;
    String description;
    String latitude;
    String longitude;

    public Diary(String name, String description, String latitude, String longitude){
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName(){
        return name;
    }
}
