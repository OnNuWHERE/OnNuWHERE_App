package com.example.onnuwhere.model;

public class AED {
    private long rnum;

    private String buildAddress;
    private String buildPlace;
    private long clerkTel;

    private double wgs84Lat;
    private double wgs84Lon;

    private String org;
    private String manager;
    private String managerTel;

    private String mfg;
    private String model;

    private int zipcode1;
    private int zipcode2;

    private String gugun;
    private String sido;

    private String sunFrtYon;
    private String sunScdYon;
    private String sunThiYon;
    private String sunFurYon;
    private String sunFifYon;

    private int holEndTme;
    private int holSttTme;

    private int monEndTme;
    private int monSttTme;
    private int tueEndTme;
    private int tueSttTme;
    private int wedEndTme;
    private int wedSttTme;
    private int thuEndTme;
    private int thuSttTme;
    private int friSttTme;
    private int friEndTme;
    private int satEndTme;
    private int satSttTme;
    private int sunSttTme;
    private int sunEndTme;

    public AED() {
        this.rnum = 0;
        this.buildAddress = "";
        this.buildPlace = "";
        this.clerkTel = 0;
        this.wgs84Lat = 0;
        this.wgs84Lon = 0;
        this.org = "";
        this.manager = "";
        this.managerTel = "";
        this.mfg = "";
        this.model = "";
        this.zipcode1 = 0;
        this.zipcode2 = 0;
        this.gugun = "";
        this.sido = "";
        this.sunFrtYon = "";
        this.sunScdYon = "";
        this.sunThiYon = "";
        this.sunFurYon = "";
        this.sunFifYon = "";
        this.monEndTme = 0;
        this.monSttTme = 0;
        this.tueEndTme = 0;
        this.tueSttTme = 0;
        this.wedEndTme = 0;
        this.wedSttTme = 0;
        this.thuEndTme = 0;
        this.thuSttTme = 0;
        this.friSttTme = 0;
        this.friEndTme = 0;
        this.satEndTme = 0;
        this.satSttTme = 0;
        this.sunSttTme = 0;
        this.sunEndTme = 0;
        this.holEndTme = 0;
        this.holSttTme = 0;

    }

    public AED(long rnum, String buildAddress, String buildPlace, long clerkTel, double wgs84Lat, double wgs84Lon, String org, String manager, String managerTel, String mfg, String model, int zipcode1, int zipcode2, String gugun, String sido, String sunFrtYon, String sunScdYon, String sunThiYon, String sunFurYon, String sunFifYon, int monEndTme, int monSttTme, int tueEndTme, int tueSttTme, int wedEndTme, int wedSttTme, int thuEndTme, int thuSttTme, int friSttTme, int friEndTme, int satEndTme, int satSttTme, int sunSttTme, int sunEndTme) {
        this.rnum = rnum;
        this.buildAddress = buildAddress;
        this.buildPlace = buildPlace;
        this.clerkTel = clerkTel;
        this.wgs84Lat = wgs84Lat;
        this.wgs84Lon = wgs84Lon;
        this.org = org;
        this.manager = manager;
        this.managerTel = managerTel;
        this.mfg = mfg;
        this.model = model;
        this.zipcode1 = zipcode1;
        this.zipcode2 = zipcode2;
        this.gugun = gugun;
        this.sido = sido;
        this.sunFrtYon = sunFrtYon;
        this.sunScdYon = sunScdYon;
        this.sunThiYon = sunThiYon;
        this.sunFurYon = sunFurYon;
        this.sunFifYon = sunFifYon;
        this.monEndTme = monEndTme;
        this.monSttTme = monSttTme;
        this.tueEndTme = tueEndTme;
        this.tueSttTme = tueSttTme;
        this.wedEndTme = wedEndTme;
        this.wedSttTme = wedSttTme;
        this.thuEndTme = thuEndTme;
        this.thuSttTme = thuSttTme;
        this.friSttTme = friSttTme;
        this.friEndTme = friEndTme;
        this.satEndTme = satEndTme;
        this.satSttTme = satSttTme;
        this.sunSttTme = sunSttTme;
        this.sunEndTme = sunEndTme;
    }

    public int getHolEndTme() {
        return holEndTme;
    }

    public void setHolEndTme(int holEndTme) {
        this.holEndTme = holEndTme;
    }

    public int getHolSttTme() {
        return holSttTme;
    }

    public void setHolSttTme(int holSttTme) {
        this.holSttTme = holSttTme;
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

    public long getClerkTel() {
        return clerkTel;
    }

    public void setClerkTel(long clerkTel) {
        this.clerkTel = clerkTel;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
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

    public String getSunFrtYon() {
        return sunFrtYon;
    }

    public void setSunFrtYon(String sunFrtYon) {
        this.sunFrtYon = sunFrtYon;
    }

    public String getSunScdYon() {
        return sunScdYon;
    }

    public void setSunScdYon(String sunScdYon) {
        this.sunScdYon = sunScdYon;
    }

    public String getSunThiYon() {
        return sunThiYon;
    }

    public void setSunThiYon(String sunThiYon) {
        this.sunThiYon = sunThiYon;
    }

    public String getSunFurYon() {
        return sunFurYon;
    }

    public void setSunFurYon(String sunFurYon) {
        this.sunFurYon = sunFurYon;
    }

    public String getSunFifYon() {
        return sunFifYon;
    }

    public void setSunFifYon(String sunFifYon) {
        this.sunFifYon = sunFifYon;
    }

    public int getMonEndTme() {
        return monEndTme;
    }

    public void setMonEndTme(int monEndTme) {
        this.monEndTme = monEndTme;
    }

    public int getMonSttTme() {
        return monSttTme;
    }

    public void setMonSttTme(int monSttTme) {
        this.monSttTme = monSttTme;
    }

    public int getTueEndTme() {
        return tueEndTme;
    }

    public void setTueEndTme(int tueEndTme) {
        this.tueEndTme = tueEndTme;
    }

    public int getTueSttTme() {
        return tueSttTme;
    }

    public void setTueSttTme(int tueSttTme) {
        this.tueSttTme = tueSttTme;
    }

    public int getWedEndTme() {
        return wedEndTme;
    }

    public void setWedEndTme(int wedEndTme) {
        this.wedEndTme = wedEndTme;
    }

    public int getWedSttTme() {
        return wedSttTme;
    }

    public void setWedSttTme(int wedSttTme) {
        this.wedSttTme = wedSttTme;
    }

    public int getThuEndTme() {
        return thuEndTme;
    }

    public void setThuEndTme(int thuEndTme) {
        this.thuEndTme = thuEndTme;
    }

    public int getThuSttTme() {
        return thuSttTme;
    }

    public void setThuSttTme(int thuSttTme) {
        this.thuSttTme = thuSttTme;
    }

    public int getFriSttTme() {
        return friSttTme;
    }

    public void setFriSttTme(int friSttTme) {
        this.friSttTme = friSttTme;
    }

    public int getFriEndTme() {
        return friEndTme;
    }

    public void setFriEndTme(int friEndTme) {
        this.friEndTme = friEndTme;
    }

    public int getSatEndTme() {
        return satEndTme;
    }

    public void setSatEndTme(int satEndTme) {
        this.satEndTme = satEndTme;
    }

    public int getSatSttTme() {
        return satSttTme;
    }

    public void setSatSttTme(int satSttTme) {
        this.satSttTme = satSttTme;
    }

    public int getSunSttTme() {
        return sunSttTme;
    }

    public void setSunSttTme(int sunSttTme) {
        this.sunSttTme = sunSttTme;
    }

    public int getSunEndTme() {
        return sunEndTme;
    }

    public void setSunEndTme(int sunEndTme) {
        this.sunEndTme = sunEndTme;
    }

    @Override
    public String toString() {
        return "Civil{" +
                "rnum=" + rnum +
                ", buildAddress='" + buildAddress + '\'' +
                ", buildPlace='" + buildPlace + '\'' +
                ", clerkTel=" + clerkTel +
                ", wgs84Lat=" + wgs84Lat +
                ", wgs84Lon=" + wgs84Lon +
                ", org='" + org + '\'' +
                ", manager='" + manager + '\'' +
                ", managerTel='" + managerTel + '\'' +
                ", mfg='" + mfg + '\'' +
                ", model='" + model + '\'' +
                ", zipcode1=" + zipcode1 +
                ", zipcode2=" + zipcode2 +
                ", gugun='" + gugun + '\'' +
                ", sido='" + sido + '\'' +
                ", sunFrtYon='" + sunFrtYon + '\'' +
                ", sunScdYon='" + sunScdYon + '\'' +
                ", sunThiYon='" + sunThiYon + '\'' +
                ", sunFurYon='" + sunFurYon + '\'' +
                ", sunFifYon='" + sunFifYon + '\'' +
                ", monEndTme=" + monEndTme +
                ", monSttTme=" + monSttTme +
                ", tueEndTme=" + tueEndTme +
                ", tueSttTme=" + tueSttTme +
                ", wedEndTme=" + wedEndTme +
                ", wedSttTme=" + wedSttTme +
                ", thuEndTme=" + thuEndTme +
                ", thuSttTme=" + thuSttTme +
                ", friSttTme=" + friSttTme +
                ", friEndTme=" + friEndTme +
                ", satEndTme=" + satEndTme +
                ", satSttTme=" + satSttTme +
                ", sunSttTme=" + sunSttTme +
                ", sunEndTme=" + sunEndTme +
                '}';
    }
}
