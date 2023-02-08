package com.example.onnuwhere.model;

public class Recycle {
    String title;
    String address;
    double lat;
    double lon;


    public Recycle(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Recycle(String title, String address, double lat, double lon) {
        this.title = title;
        this.address = address;
        this.lat = lat;
        this.lon = lon;
    }
}
