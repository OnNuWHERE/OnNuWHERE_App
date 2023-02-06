package com.example.onnuwhere.model;

public class AED {
    private long rnum;

    private String buildAddress;
    private String buildPlace;

    private double wgs84Lat;
    private double wgs84Lon;

    private String org;

    private String mfg;
    private String model;

    private int zipcode1;
    private int zipcode2;

    private String gugun;
    private String sido;




    public AED() {
        this.rnum = 0;
        this.buildAddress = "";
        this.buildPlace = "";
        this.wgs84Lat = 0;
        this.wgs84Lon = 0;
        this.org = "";
        this.mfg = "";
        this.model = "";
        this.zipcode1 = 0;
        this.zipcode2 = 0;
        this.gugun = "";
        this.sido = "";
    }

    public AED(long rnum, String buildAddress, String buildPlace, long clerkTel, double wgs84Lat, double wgs84Lon, String org, String manager, String managerTel, String mfg, String model, int zipcode1, int zipcode2, String gugun, String sido, String sunFrtYon, String sunScdYon, String sunThiYon, String sunFurYon, String sunFifYon, int monEndTme, int monSttTme, int tueEndTme, int tueSttTme, int wedEndTme, int wedSttTme, int thuEndTme, int thuSttTme, int friSttTme, int friEndTme, int satEndTme, int satSttTme, int sunSttTme, int sunEndTme) {
        this.rnum = rnum;
        this.buildAddress = buildAddress;
        this.buildPlace = buildPlace;
        this.wgs84Lat = wgs84Lat;
        this.wgs84Lon = wgs84Lon;
        this.org = org;
        this.mfg = mfg;
        this.model = model;
        this.zipcode1 = zipcode1;
        this.zipcode2 = zipcode2;
        this.gugun = gugun;
        this.sido = sido;
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





    public double getWgs84Lat() {
        return wgs84Lat;
    }

    public void setWgs84Lat(double wgs84Lat) {
        this.wgs84Lat = wgs84Lat;
    }

    public double getWgs84Lon() {
        return wgs84Lon;
    }

    public void setWgs84Lon(double wgs84Lon) {
        this.wgs84Lon = wgs84Lon;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
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


    @Override
    public String toString() {
        return "Civil{" +
                "rnum=" + rnum +
                ", buildAddress='" + buildAddress + '\'' +
                ", buildPlace='" + buildPlace + '\'' +
                ", wgs84Lat=" + wgs84Lat +
                ", wgs84Lon=" + wgs84Lon +
                ", org='" + org + '\'' +
                ", mfg='" + mfg + '\'' +
                ", model='" + model + '\'' +
                ", zipcode1=" + zipcode1 +
                ", zipcode2=" + zipcode2 +
                ", gugun='" + gugun + '\'' +
                ", sido='" + sido + '\'' +
                '}';
    }
}
