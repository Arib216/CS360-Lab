package com.example.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CityListTest {
    // helper method to create a mock CityList with one city in it
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    // helper method to create a standard mock City
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("YellowKnife", "Northwest Territories");
        cityList.add(city);

        // Assert that adding it second time throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // mock city is "Edmonton". It should be at index 0
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // "Charlottetown" comes before "Edmonton" alphabetically
        // It should push "Edmonton" to index 1 and take index 0.
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(city));

        City cityNotInList = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(cityNotInList));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        
        // Check if city is present
        assertTrue(cityList.hasCity(city));
        
        // Delete it
        cityList.delete(city);
        
        // Check if it's removed
        assertFalse(cityList.hasCity(city));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "BC");
        
        // Assert that deleting a city not in the list throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        
        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());
        
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
    }
}
