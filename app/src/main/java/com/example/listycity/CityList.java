package com.example.listycity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * adds a city to the list if not already in the list
     * @param city
     * this is a candidate city to be added to the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);

    }
    /**
     * returns a sorted list of cities
     * @return a sorted list of cities
     */

    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    public boolean hasCity(City city){
        return cities.contains(city);

    }


}
