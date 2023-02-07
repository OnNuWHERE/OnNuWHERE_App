package com.example.onnuwhere.model;

public class EarthquakeOutdoorsShelter {


    private long arcd;
    private long acmdfclty_sn;

    private String ctprvn_nm;
    private String sgg_nm;
    private String title;

    private String address;

    private long fclty_ar;

    private double lon;
    private double lat;


    @Override
    public String toString() {
        return "EarthquakeOutdoorsShelter{" +
                "acmdfclty_sn=" + acmdfclty_sn +
                ", arcd=" + arcd +
                ", sgg_nm='" + sgg_nm + '\'' +
                ", ctprvn_nm='" + ctprvn_nm + '\'' +
                ", dtl_adres='" + address + '\'' +
                ", vt_acmdfclty_nm='" + title + '\'' +
                ", fclty_ar=" + fclty_ar +
                ", xcord=" + lon +
                ", ycord=" + lat +
                '}';
    }

    public long getAcmdfclty_sn() {
        return acmdfclty_sn;
    }

    public void setAcmdfclty_sn(long acmdfclty_sn) {
        this.acmdfclty_sn = acmdfclty_sn;
    }

    public long getArcd() {
        return arcd;
    }

    public void setArcd(long arcd) {
        this.arcd = arcd;
    }

    public String getSgg_nm() {
        return sgg_nm;
    }

    public void setSgg_nm(String sgg_nm) {
        this.sgg_nm = sgg_nm;
    }

    public String getCtprvn_nm() {
        return ctprvn_nm;
    }

    public void setCtprvn_nm(String ctprvn_nm) {
        this.ctprvn_nm = ctprvn_nm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getFclty_ar() {
        return fclty_ar;
    }

    public void setFclty_ar(long fclty_ar) {
        this.fclty_ar = fclty_ar;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public EarthquakeOutdoorsShelter(long acmdfclty_sn, long arcd, String sgg_nm, String ctprvn_nm, String dtl_adres, String vt_acmdfclty_nm, long fclty_ar, double xcord, double ycord) {
        this.acmdfclty_sn = acmdfclty_sn;
        this.arcd = arcd;
        this.sgg_nm = sgg_nm;
        this.ctprvn_nm = ctprvn_nm;
        this.address = dtl_adres;
        this.title = vt_acmdfclty_nm;
        this.fclty_ar = fclty_ar;
        this.lon = xcord;
        this.lat = ycord;
    }

    public EarthquakeOutdoorsShelter() {

    }



}
