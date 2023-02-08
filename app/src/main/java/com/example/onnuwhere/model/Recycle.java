package com.example.onnuwhere.model;

public class Recycle{
    private String title;
    private String address;
    private String category;
    private double lat;
    private double lon;
    private double dis;


    public Recycle() {

    }

    public double getDis() {
        return dis;
    }

    public void setDis(double dis) {
        this.dis = dis;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Recycle(String title, String address, double lat, double lon, String category, double dis) {
        this.title = title;
        this.address = address;
        this.lat = lat;
        this.lon = lon;
        this.category = category;
        this.dis = dis;
    }

}
