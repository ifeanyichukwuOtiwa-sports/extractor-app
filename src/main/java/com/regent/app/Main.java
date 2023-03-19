package com.regent.app;

import java.util.List;

import com.regent.extractor.CallingCodeExtractor;
import com.regent.extractor.CountryExtractor;
import com.regent.utils.ExtractorUtils;

public class Main {
    public static void main(String[] args) {
        final CallingCodeExtractor callingCodeExtractor = new CallingCodeExtractor();
        final CountryExtractor countryExtractor = new CountryExtractor();
        final List<String> countryList = countryExtractor.getCountryList();
        countryList.forEach(item -> {
            if (item.split("\\s").length > 1) {
                String temp = ExtractorUtils.convertToIString(item);
                final String phoneNumbers = callingCodeExtractor.getPhoneNumbers(temp, ExtractorUtils.getRandomTenDigitNumber());
                System.out.println((phoneNumbers.startsWith("-") ? phoneNumbers : "+" + phoneNumbers) + " " + item);
            } else {
                final String phoneNumbers = callingCodeExtractor.getPhoneNumbers(item, ExtractorUtils.getRandomTenDigitNumber());
                System.out.println(phoneNumbers.startsWith("-") ? phoneNumbers : "+" + phoneNumbers);
            }
        });
    }
}