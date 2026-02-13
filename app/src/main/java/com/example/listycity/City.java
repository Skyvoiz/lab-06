package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a city.
 */

public class City implements Comparable<City>{
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    String getCityName(){
        return this.city;
    }
    String getProvinceName(){
        return this.province;
    }

    /**
     * Checks if same name and province
     * @param o   the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                          // same object
        if (!(o instanceof City)) return false;              // wrong type
        City other = (City) o;
        return Objects.equals(city, other.city)
                && Objects.equals(province, other.province);
    }

    /**
     * checks if two objects have same hashcode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    /**
     * Compares a given city name to a current city name
     * @param o
     * @return
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
