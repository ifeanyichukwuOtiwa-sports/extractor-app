package com.regent;

public class CountryData {
    private String country;
    private String region;

    public CountryData() {
    }

    public CountryData(final String country, final String region) {
        this.country = country;
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }
}
