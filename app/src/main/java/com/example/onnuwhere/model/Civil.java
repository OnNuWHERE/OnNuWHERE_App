package com.example.onnuwhere.model;

public class Civil {
    public long cNum;

    public long validDate;

    public long updateDate;

    public long updateTime;

    public long zipcode;

    public String bloAddr;
    public String stAddr;

    public String buildAddr;
    public String buildPlace;

    public long orgCd;
    public String orgType;
    public String org;

    public String serialCd;

    public double updateUoI;

    public double epsg2097X;
    public double epsg2097Y;

    public Civil(long cNum, long validDate, long updateDate, long updateTime, long zipcode, String bloAddr, String stAddr, String buildAddr, String buildPlace, long orgCd, String orgType, String org, String serialCd, double updateUoI, double epsg2097X, double epsg2097Y) {
        this.cNum = cNum;
        this.validDate = validDate;
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
        this.updateUoI = updateUoI;
        this.epsg2097X = epsg2097X;
        this.epsg2097Y = epsg2097Y;
    }

    public long getcNum() {
        return cNum;
    }

    public void setcNum(long cNum) {
        this.cNum = cNum;
    }

    public long getValidDate() {
        return validDate;
    }

    public void setValidDate(long validDate) {
        this.validDate = validDate;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public String getBloAddr() {
        return bloAddr;
    }

    public void setBloAddr(String bloAddr) {
        this.bloAddr = bloAddr;
    }

    public String getStAddr() {
        return stAddr;
    }

    public void setStAddr(String stAddr) {
        this.stAddr = stAddr;
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

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getSerialCd() {
        return serialCd;
    }

    public void setSerialCd(String serialCd) {
        this.serialCd = serialCd;
    }

    public double getUpdateUoI() {
        return updateUoI;
    }

    public void setUpdateUoI(double updateUoI) {
        this.updateUoI = updateUoI;
    }

    public double getEpsg2097X() {
        return epsg2097X;
    }

    public void setEpsg2097X(double epsg2097X) {
        this.epsg2097X = epsg2097X;
    }

    public double getEpsg2097Y() {
        return epsg2097Y;
    }

    public void setEpsg2097Y(double epsg2097Y) {
        this.epsg2097Y = epsg2097Y;
    }

    @Override
    public String toString() {
        return "Civil{" +
                "cNum=" + cNum +
                ", validDate=" + validDate +
                ", updateDate=" + updateDate +
                ", updateTime=" + updateTime +
                ", zipcode=" + zipcode +
                ", bloAddr='" + bloAddr + '\'' +
                ", stAddr='" + stAddr + '\'' +
                ", buildAddr='" + buildAddr + '\'' +
                ", buildPlace='" + buildPlace + '\'' +
                ", orgCd=" + orgCd +
                ", orgType='" + orgType + '\'' +
                ", org='" + org + '\'' +
                ", serialCd='" + serialCd + '\'' +
                ", updateUoI=" + updateUoI +
                ", epsg2097X=" + epsg2097X +
                ", epsg2097Y=" + epsg2097Y +
                '}';
    }
}
