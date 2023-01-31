package com.example.onnuwhere.model;

public class EarthquakeOutdoorsShelter {


    private long acmdfclty_sn;

    private String arcd;
    private String rdnmadr_cd;
    private String bdong_cd;
    private String hdong_cd;

    private String sgg_nm;
    private String ctprvn_nm;
    private String dtl_adres;

    private String vt_acmdfclty_nm;

    private long fclty_ar;

    private String xcord;
    private String ycord;

    public EarthquakeOutdoorsShelter(long acmdfclty_sn, String arcd, String rdnmadr_cd, String bdong_cd, String hdong_cd, String sgg_nm, String ctprvn_nm, String dtl_adres, String vt_acmdfclty_nm, long fclty_ar, String xcord, String ycord) {
        this.acmdfclty_sn = acmdfclty_sn;
        this.arcd = arcd;
        this.rdnmadr_cd = rdnmadr_cd;
        this.bdong_cd = bdong_cd;
        this.hdong_cd = hdong_cd;
        this.sgg_nm = sgg_nm;
        this.ctprvn_nm = ctprvn_nm;
        this.dtl_adres = dtl_adres;
        this.vt_acmdfclty_nm = vt_acmdfclty_nm;
        this.fclty_ar = fclty_ar;
        this.xcord = xcord;
        this.ycord = ycord;
    }

    public long getAcmdfclty_sn() {
        return acmdfclty_sn;
    }

    public void setAcmdfclty_sn(long acmdfclty_sn) {
        this.acmdfclty_sn = acmdfclty_sn;
    }

    public String getArcd() {
        return arcd;
    }

    public void setArcd(String arcd) {
        this.arcd = arcd;
    }

    public String getRdnmadr_cd() {
        return rdnmadr_cd;
    }

    public void setRdnmadr_cd(String rdnmadr_cd) {
        this.rdnmadr_cd = rdnmadr_cd;
    }

    public String getBdong_cd() {
        return bdong_cd;
    }

    public void setBdong_cd(String bdong_cd) {
        this.bdong_cd = bdong_cd;
    }

    public String getHdong_cd() {
        return hdong_cd;
    }

    public void setHdong_cd(String hdong_cd) {
        this.hdong_cd = hdong_cd;
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

    public String getXcord() {
        return xcord;
    }

    public void setXcord(String xcord) {
        this.xcord = xcord;
    }

    public String getYcord() {
        return ycord;
    }

    public void setYcord(String ycord) {
        this.ycord = ycord;
    }

    @Override
    public String toString() {
        return "EarthquakeOutdoorsShelter{" +
                "acmdfclty_sn=" + acmdfclty_sn +
                ", arcd='" + arcd + '\'' +
                ", rdnmadr_cd='" + rdnmadr_cd + '\'' +
                ", bdong_cd='" + bdong_cd + '\'' +
                ", hdong_cd='" + hdong_cd + '\'' +
                ", sgg_nm='" + sgg_nm + '\'' +
                ", ctprvn_nm='" + ctprvn_nm + '\'' +
                ", dtl_adres='" + dtl_adres + '\'' +
                ", vt_acmdfclty_nm='" + vt_acmdfclty_nm + '\'' +
                ", fclty_ar=" + fclty_ar +
                ", xcord='" + xcord + '\'' +
                ", ycord='" + ycord + '\'' +
                '}';
    }
}
