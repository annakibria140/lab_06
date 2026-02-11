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

    /**
     * removes a city from the list
     * @param city the city to be removed
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city){
        if (!hasCity(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * checks if a city is in the list
     * @param city
     * @return true or false if city is in the list or not
     */
    public boolean hasCity(City city){
        return cities.contains(city);

    }

    /**
     * counts the number of cities in the list
     * @return the number of cities in the list
     */
    public int countCities(){
        return cities.size();
    }


}
