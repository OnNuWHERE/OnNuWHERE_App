package com.example.onnuwhere.model;

public class TsunamiShelter {


    private long id;

    private String seismic;
    private String shel_div_type;
    private String remarks;
    private String shel_nm;

    private long height;
    private long lenth;

    private long shel_av;

    private String sido_name;
    private String sigungu_name;
    private String address;

    private double lon;
    private double lat;

    public TsunamiShelter() {
        
    }

    public TsunamiShelter(long id, String seismic, String shel_div_type, String remarks, String shel_nm, long height, long lenth, long shel_av, String sido_name, String sigungu_name, String address, double lon, double lat) {
        this.id = id;
        this.seismic = seismic;
        this.shel_div_type = shel_div_type;
        this.remarks = remarks;
        this.shel_nm = shel_nm;
        this.height = height;
        this.lenth = lenth;
        this.shel_av = shel_av;
        this.sido_name = sido_name;
        this.sigungu_name = sigungu_name;
        this.address = address;
        this.lon = lon;
        this.lat = lat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeismic() {
        return seismic;
    }

    public void setSeismic(String seismic) {
        this.seismic = seismic;
    }

    public String getShel_div_type() {
        return shel_div_type;
    }

    public void setShel_div_type(String shel_div_type) {
        this.shel_div_type = shel_div_type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getShel_nm() {
        return shel_nm;
    }

    public void setShel_nm(String shel_nm) {
        this.shel_nm = shel_nm;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getLenth() {
        return lenth;
    }

    public void setLenth(long lenth) {
        this.lenth = lenth;
    }

    public long getShel_av() {
        return shel_av;
    }

    public void setShel_av(long shel_av) {
        this.shel_av = shel_av;
    }

    public String getSido_name() {
        return sido_name;
    }

    public void setSido_name(String sido_name) {
        this.sido_name = sido_name;
    }

    public String getSigungu_name() {
        return sigungu_name;
    }

    public void setSigungu_name(String sigungu_name) {
        this.sigungu_name = sigungu_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "TsunamiShelter{" +
                "id=" + id +
                ", seismic='" + seismic + '\'' +
                ", shel_div_type='" + shel_div_type + '\'' +
                ", remarks='" + remarks + '\'' +
                ", shel_nm='" + shel_nm + '\'' +
                ", height=" + height +
                ", lenth=" + lenth +
                ", shel_av=" + shel_av +
                ", sido_name='" + sido_name + '\'' +
                ", sigungu_name='" + sigungu_name + '\'' +
                ", address='" + address + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
