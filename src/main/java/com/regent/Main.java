package com.regent;

import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        final CallingCodeExtractor callingCodeExtractor = new CallingCodeExtractor();
        final CountryExtractor countryExtractor = new CountryExtractor();
        final List<String> countryList = countryExtractor.getCountryList();
        countryList.forEach(item -> {
            if (item.split("\\s").length > 1){
                System.out.println(item);
                String temp = convertToIString(item);
                final String phoneNumbers = callingCodeExtractor.getPhoneNumbers(temp, getRandomTenDigitNumber());
                System.out.println(phoneNumbers.startsWith("-") ? phoneNumbers : "+" + phoneNumbers);
            } else {
                final String phoneNumbers = callingCodeExtractor.getPhoneNumbers(item, getRandomTenDigitNumber());
                System.out.println(phoneNumbers.startsWith("-") ? phoneNumbers : "+" + phoneNumbers);
            }
        });
    }

    public static String getRandomTenDigitNumber() {
        Random random = new Random();
        return String.format("%s",random.nextLong(7020000000L, 7039999999L));
    }

    public static String convertToIString(final String item) {
        final String[] s = item.split(" ");
        return s[0];
    }
}