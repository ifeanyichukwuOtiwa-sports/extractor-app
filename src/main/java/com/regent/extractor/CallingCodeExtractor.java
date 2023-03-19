package com.regent.extractor;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.regent.utils.ConnectionUtils;
import com.regent.response.Response;
import com.regent.response.ResponseData;

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
