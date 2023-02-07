package com.example.onnuwhere.model;

public class Civil {

    private double X;
    private double Y;
    private String bloAddr;
    private String buildAddr;
    private String buildPlace;
    private long cNum;
    private String org;
    private long orgCd;
    private String orgType;
    private String serialCd;
    private String stAddr;
    private String update;
    private long updateDate;
    private String updateTime;
    private long validDate;
    private long zipcode;

    public Civil() {
    }

    public Civil(long cNum, long validDate, String update, long updateDate, String updateTime, long zipcode, String bloAddr, String stAddr, String buildAddr, String buildPlace, long orgCd, String orgType, String org, String serialCd, double epsg2097X, double epsg2097Y, double x, double y) {
        this.cNum = cNum;
        this.validDate = validDate;
        this.update = update;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.zipcode = zipcode;
        this.bloAddr = bloAddr;
        this.stAddr = stAddr;
        this.buildAddr = buildAddr;
        this.buildPlace = buildPlace;
        this.orgCd = orgCd;
        this.orgType = orgType;
        this.org = org;
        this.serialCd = serialCd;
        X = x;
        Y = y;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public String getBloAddr() {
        return bloAddr;
    }

    public void setBloAddr(String bloAddr) {
        this.bloAddr = bloAddr;
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

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public long getOrgCd() {
        return orgCd;
    }

    public void setOrgCd(long orgCd) {
        this.orgCd = orgCd;
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

    public String getStAddr() {
        return stAddr;
    }

    public void setStAddr(String stAddr) {
        this.stAddr = stAddr;
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

    public long getValidDate() {
        return validDate;
    }

    public void setValidDate(long validDate) {
        this.validDate = validDate;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Civil{" +
                "cNum=" + cNum +
                ", validDate=" + validDate +
                ", update='" + update + '\'' +
                ", updateDate=" + updateDate +
                ", updateTime='" + updateTime + '\'' +
                ", zipcode=" + zipcode +
                ", bloAddr='" + bloAddr + '\'' +
                ", stAddr='" + stAddr + '\'' +
                ", buildAddr='" + buildAddr + '\'' +
                ", buildPlace='" + buildPlace + '\'' +
                ", orgCd=" + orgCd +
                ", orgType='" + orgType + '\'' +
                ", org='" + org + '\'' +
                ", serialCd='" + serialCd + '\'' +
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }
}
