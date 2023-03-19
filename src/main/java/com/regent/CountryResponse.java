package com.regent;

import java.util.Map;

public class CountryResponse {
    private Map<String, CountryData> data;

    public CountryResponse() {
    }

    public CountryResponse(final Map<String, CountryData> data) {
        this.data = data;
    }

    public Map<String, CountryData> getData() {
        return data;
    }

    public void setData(final Map<String, CountryData> data) {
        this.data = data;
    }
}
