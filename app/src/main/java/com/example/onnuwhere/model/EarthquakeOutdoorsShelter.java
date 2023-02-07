package com.example.onnuwhere.model;

public class EarthquakeOutdoorsShelter {


    private long arcd;
    private long acmdfclty_sn;

    private String ctprvn_nm;
    private String sgg_nm;
    private String vt_acmdfclty_nm;

    private String dtl_adres;

    private long fclty_ar;

    private double xcord;
    private double ycord;


    @Override
    public String toString() {
        return "EarthquakeOutdoorsShelter{" +
                "acmdfclty_sn=" + acmdfclty_sn +
                ", arcd=" + arcd +
                ", sgg_nm='" + sgg_nm + '\'' +
                ", ctprvn_nm='" + ctprvn_nm + '\'' +
                ", dtl_adres='" + dtl_adres + '\'' +
                ", vt_acmdfclty_nm='" + vt_acmdfclty_nm + '\'' +
                ", fclty_ar=" + fclty_ar +
                ", xcord=" + xcord +
                ", ycord=" + ycord +
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

    public String getDtl_adres() {
        return dtl_adres;
    }

    public void setDtl_adres(String dtl_adres) {
        this.dtl_adres = dtl_adres;
    }

    public String getVt_acmdfclty_nm() {
        return vt_acmdfclty_nm;
    }

    public void setVt_acmdfclty_nm(String vt_acmdfclty_nm) {
        this.vt_acmdfclty_nm = vt_acmdfclty_nm;
    }

    public long getFclty_ar() {
        return fclty_ar;
    }

    public void setFclty_ar(long fclty_ar) {
        this.fclty_ar = fclty_ar;
    }

    public double getXcord() {
        return xcord;
    }

    public void setXcord(double xcord) {
        this.xcord = xcord;
    }

    public double getYcord() {
        return ycord;
    }

    public void setYcord(double ycord) {
        this.ycord = ycord;
    }

    public EarthquakeOutdoorsShelter(long acmdfclty_sn, long arcd, String sgg_nm, String ctprvn_nm, String dtl_adres, String vt_acmdfclty_nm, long fclty_ar, double xcord, double ycord) {
        this.acmdfclty_sn = acmdfclty_sn;
        this.arcd = arcd;
        this.sgg_nm = sgg_nm;
        this.ctprvn_nm = ctprvn_nm;
        this.dtl_adres = dtl_adres;
        this.vt_acmdfclty_nm = vt_acmdfclty_nm;
        this.fclty_ar = fclty_ar;
        this.xcord = xcord;
        this.ycord = ycord;
    }

    public EarthquakeOutdoorsShelter() {

    }



}
