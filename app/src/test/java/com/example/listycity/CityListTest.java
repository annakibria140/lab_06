package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("YellowKnife", "NorthWest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        //checks the first city in the cityList
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        //this pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        //now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        //checks to see if the city is in the list
        assertTrue(cityList.hasCity(city));
        //checks to see if a random city is not in the list
        assertFalse(cityList.hasCity(new City("Toronto", "Ontario")));
        City city2 = new City("Hinton", "Alberta");
        cityList.add(city2);
        //check to see if hinton is in the list and remove it if it is
        if (cityList.hasCity(city2)){
            cityList.getCities().remove(city2);
        } else {
            throw new IllegalArgumentException();
        }

    }
}
