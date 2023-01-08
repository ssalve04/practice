package com.beatr.restapidemo1.entity;

public class Address {

    private String zipcode;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipcode='" + zipcode + '\'' +
                '}';
    }
}
