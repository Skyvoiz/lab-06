package com.example.listycity;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City ("Winnipeg", "Manitoba");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCityTrue() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    public void testHasCityFalse() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    public void testDeleteRemovesCity() {
        CityList cityList = mockCityList();
        City city = mockCity();

        cityList.delete(city);

        assertFalse(cityList.hasCity(city));
        assertEquals(0, cityList.countCities());
    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
    }
}
