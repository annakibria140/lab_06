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

    /**
     * this is a constructor that takes in a city and province
     * @param city
     * @param province
     */

    public City(String city, String province) {
        this.city = city;
        this.province = province;
        }


    /**
     * this is a getter for the city name
     * @return the city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * this is a getter for the province name
     * @return the province name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * this compares the city objects to see if they are the same
     * @param  o the city object to compare to
     * @return true or false if they are the same
     */
     @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());

    }

}
