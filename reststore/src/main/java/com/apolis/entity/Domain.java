package com.apolis.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Domain {
    private String domain;
    @JsonProperty("create_date")
    private String createDate;
    private boolean isDead;
    private  String country;
    @JsonProperty("MX")
    private List<Mx> mxList;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Mx> getMxList() {
        return mxList;
    }

    public void setMxList(List<Mx> mxList) {
        this.mxList = mxList;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "domain='" + domain + '\'' +
                ", createDate='" + createDate + '\'' +
                ", isDead=" + isDead +
                ", country='" + country + '\'' +
                ", mxList=" + mxList +
                '}';
    }
    
}
