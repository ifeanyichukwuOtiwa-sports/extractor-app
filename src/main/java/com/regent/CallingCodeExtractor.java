package com.regent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

public class CallingCodeExtractor {

    private static final Gson GSON = new Gson();

    public String getPhoneNumbers(String country, String phoneNumber) {
        try {
            final StringBuilder stringBuilder = streamResponse(country);
            final String resp = stringBuilder.toString();
            final Response response = GSON.fromJson(resp, Response.class);
            final List<ResponseData> data = response.getData();

            if (data.isEmpty()) {
                return "-1";
            }

            final ResponseData responseData = data.get(0);
            final List<String> callingCodes = responseData.getCallingCodes();

            if (callingCodes.isEmpty()) {
                return "-1";
            }
            final String callingCode = callingCodes.get(0);

            return String.format("%s %s", callingCode, phoneNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static StringBuilder streamResponse(final String country) throws IOException {
        return ConnectionUtils.extractJson("https://jsonmock.hackerrank.com/api/countries?name=" + country);
    }
}
