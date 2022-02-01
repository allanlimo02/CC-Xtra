package com.example.currencyconverterapp.SharedResourcesFiles;

public class PreferenceItems {
    private String country1;
    private String country2;
    private String amount;


    public PreferenceItems(String country1, String country2, String amount) {
        this.country1 = country1;
        this.country2 = country2;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public String getCountry1() {
        return country1;
    }

    public String getCountry2() {
        return country2;
    }
}
