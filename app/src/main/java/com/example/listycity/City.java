package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this is a class that defines the city and province
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    public City(String city, String province) {
        this.city = city;
        this.province = province;
        }

    public String getCityName() {
        return this.city;
    }

    public String getProvinceName() {
        return this.province;
    }

     @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());

    }

}
