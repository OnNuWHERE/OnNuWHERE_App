package com.example.onnuwhere.model;

import java.util.List;

public class AED{
    private long rnum;

    private String buildAddress;
    private String buildPlace;

    private double lat;
    private double lon;

    private String title;

    private String mfg;
    private String model;

    private int zipcode1;
    private int zipcode2;

    private String gugun;
    private String sido;
    private String address;




    public AED() {
        this.rnum = 0;
        this.buildAddress = "";
        this.buildPlace = "";
        this.lat = 0;
        this.lon = 0;
        this.title = "";
        this.mfg = "";
        this.model = "";
        this.zipcode1 = 0;
        this.zipcode2 = 0;
        this.gugun = "";
        this.sido = "";
        this.address = "";
    }

    public AED(long rnum, String buildAddress, String buildPlace, double lat, double lon, String title, String mfg, String model, int zipcode1, int zipcode2, String gugun, String sido,String address) {
        this.rnum = rnum;
        this.buildAddress = buildAddress;
        this.buildPlace = buildPlace;
        this.lat = lat;
        this.lon = lon;
        this.title = title;
        this.mfg = mfg;
        this.model = model;
        this.zipcode1 = zipcode1;
        this.zipcode2 = zipcode2;
        this.gugun = gugun;
        this.sido = sido;
        this.address = address;
    }

    public long getRnum() {
        return rnum;
    }

    public void setRnum(long rnum) {
        this.rnum = rnum;
    }

    public String getBuildAddress() {
        return buildAddress;
    }

    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }

    public String getBuildPlace() {
        return buildPlace;
    }

    public void setBuildPlace(String buildPlace) {
        this.buildPlace = buildPlace;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMfg() {
        return mfg;
    }

    public void setMfg(String mfg) {
        this.mfg = mfg;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getZipcode1() {
        return zipcode1;
    }

    public void setZipcode1(int zipcode1) {
        this.zipcode1 = zipcode1;
    }

    public int getZipcode2() {
        return zipcode2;
    }

    public void setZipcode2(int zipcode2) {
        this.zipcode2 = zipcode2;
    }

    public String getGugun() {
        return gugun;
    }

    public void setGugun(String gugun) {
        this.gugun = gugun;
    }

    public String getSido() {
        return sido;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Civil{" +
                "rnum=" + rnum +
                ", buildAddress='" + buildAddress + '\'' +
                ", buildPlace='" + buildPlace + '\'' +
                ", wgs84Lat=" + lat +
                ", wgs84Lon=" + lon +
                ", org='" + title + '\'' +
                ", mfg='" + mfg + '\'' +
                ", model='" + model + '\'' +
                ", zipcode1=" + zipcode1 +
                ", zipcode2=" + zipcode2 +
                ", gugun='" + gugun + '\'' +
                ", sido='" + sido + '\'' +
                '}';
    }
}
