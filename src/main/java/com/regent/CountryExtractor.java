package com.regent;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class CountryExtractor {

    private static final Gson GSON = new Gson();

    private static StringBuilder streamCountryResponse(final String region, final String limit) throws IOException {
        return ConnectionUtils.extractJson("https://api.first.org/data/v1/countries?region=" + region + "&limit=" + limit + "&pretty=true");
    }

    public List<String> getCountryList() {
        try {
            final String jsonResponseString = streamCountryResponse("Africa", "150").toString();
            final CountryResponse countryResponse = GSON.fromJson(jsonResponseString, CountryResponse.class);
            final Map<String, CountryData> data = countryResponse.getData();
            return data.values().stream().map(CountryData::getCountry).toList();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
