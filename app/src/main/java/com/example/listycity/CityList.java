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
     * This adds a city to the list if the city does not already exist in the list
     *
     * @param city This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Returns a lists of cities
     *
     * @return
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a city exists in the list.
     *
     * @param city the city to check
     * @return
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Delete a city from the city list.
     *
     * @param city the city to remove
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found");
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities in the list.
     *
     * @return number of cities
     */
    public int countCities() {
        return cities.size();
    }
}
