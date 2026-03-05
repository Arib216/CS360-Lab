package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<Object> {
    private String city;
    private String province;

    /**
     * This is a constructor for the City class.
     * @param city
     * The name of the city.
     * @param province
     * The name of the province.
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the name of the city.
     * @return
     * The city name.
     */
    String getCityName() {
        return this.city;
    }

    /**
     * This returns the name of the province.
     * @return
     * The province name.
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * This checks if two cities are equal based on name and province.
     * @param o
     * The object to compare with.
     * @return
     * True if the cities are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) &&
                Objects.equals(province, city1.province);
    }

    /**
     * This returns the hash code of the city.
     * @return
     * The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    /**
     * This compares two cities alphabetically by their name.
     * @param o
     * The object to compare with.
     * @return
     * An integer representing the comparison result.
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
