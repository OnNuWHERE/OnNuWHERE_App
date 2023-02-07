package com.example.onnuwhere.model;

public class Civil {

    private double lon;
    private double lat;
    private String bloAddr;
    private String gugun;
    private String buildAddr;
    private String buildPlace;
    private long cNum;
    private String title;
    private String orgType;
    private String serialCd;
    private String address;
    private String update;
    private long updateDate;
    private String updateTime;

    public Civil() {
    }

    public Civil(long cNum, String update, long updateDate, String updateTime, String bloAddr, String address, String buildAddr, String buildPlace, String orgType, String title, String serialCd, double lon, double lat, String gugun) {
        this.cNum = cNum;
        this.update = update;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.bloAddr = bloAddr;
        this.address = address;
        this.buildAddr = buildAddr;
        this.buildPlace = buildPlace;
        this.orgType = orgType;
        this.title = title;
        this.serialCd = serialCd;
        this.lon = lon;
        this.lat = lat;
        this.gugun = gugun;
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

    public String getBloAddr() {
        return bloAddr;
    }

    public void setBloAddr(String bloAddr) {
        this.bloAddr = bloAddr;
    }

    public String getGugun() {
        return gugun;
    }

    public void setGugun(String gugun) {
        this.gugun = gugun;
    }

    public String getBuildAddr() {
        return buildAddr;
    }

    public void setBuildAddr(String buildAddr) {
        this.buildAddr = buildAddr;
    }

    public String getBuildPlace() {
        return buildPlace;
    }

    public void setBuildPlace(String buildPlace) {
        this.buildPlace = buildPlace;
    }

    public long getcNum() {
        return cNum;
    }

    public void setcNum(long cNum) {
        this.cNum = cNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getSerialCd() {
        return serialCd;
    }

    public void setSerialCd(String serialCd) {
        this.serialCd = serialCd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Civil{" +
                "cNum=" + cNum +
                ", update='" + update + '\'' +
                ", updateDate=" + updateDate +
                ", updateTime='" + updateTime + '\'' +
                ", bloAddr='" + bloAddr + '\'' +
                ", stAddr='" + address + '\'' +
                ", buildAddr='" + buildAddr + '\'' +
                ", buildPlace='" + buildPlace + '\'' +
                ", orgType='" + orgType + '\'' +
                ", org='" + title + '\'' +
                ", serialCd='" + serialCd + '\'' +
                ", X=" + lon +
                ", Y=" + lat +
                ", gugun="+ gugun + '\'' +
                '}';
    }
}
