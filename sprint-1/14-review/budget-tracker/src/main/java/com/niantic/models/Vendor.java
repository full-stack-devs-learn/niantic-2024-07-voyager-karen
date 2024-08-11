package com.niantic.models;

public class Vendor {

    private int vendorId;
    private String name;
    private String website;


    public Vendor(){

    }

    public Vendor(int vendorId, String name, String website) {
        this.vendorId = vendorId;
        this.name = name;
        this.website = website;
    }


    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String toString() {
        return String.format("Name: %s, Website: %s", name, website);
    }

}
