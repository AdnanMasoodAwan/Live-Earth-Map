package com.example.live_earth_map;

public class CountryItem
{
    String countyName;
    int countryFlag;

    public CountryItem(String countyName, int countryFlag) {
        this.countyName = countyName;
        this.countryFlag = countryFlag;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(int countryFlag) {
        this.countryFlag = countryFlag;
    }
}
