package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a class that tests the city list
 */
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
    void testHasCity() {
        CityList cityList = mockCityList();

        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(cityList.hasCity(new City("Toronto", "Ontario")));
    }

    @Test
    void testDelete_removesCity() {
        CityList cityList = new CityList();
        cityList.add(new City("Edmonton", "Alberta"));
        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());

        // delete using a NEW object with same values
        cityList.delete(new City("Regina", "Saskatchewan"));

        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(new City("Regina", "Saskatchewan")));
        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testDelete_throwsIfNotPresent() {
        CityList cityList = mockCityList();

        assertThrows(IllegalArgumentException.class, () ->
                cityList.delete(new City("Toronto", "Ontario"))
        );

        // list unchanged
        assertEquals(1, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("Edmonton", "Alberta"));
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
    }


}
