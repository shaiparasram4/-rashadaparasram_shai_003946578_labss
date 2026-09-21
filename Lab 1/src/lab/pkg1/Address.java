/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg1;

/**
 * Shai Rashada-Parasram
 * INFO 5100
 * 9/17/2026
 * Stores the manufacturing or shipping address.
 * @author shai8
 */


public class Address {

    private String streetName;
    private String unitNum;
    private String city;
    private String zipCode;

    /**
     * Creates an empty address.
     */
    public Address() {
    }

    /**
     * Creates an address with the provided details.
     */
    public Address(String streetName, String unitNum,
                   String city, String zipCode) {

        this.streetName = streetName;
        this.unitNum = unitNum;
        this.city = city;
        this.zipCode = zipCode;
    }

    /**
     * Returns the street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Returns the unit number.
     */
    public String getUnitNum() {
        return unitNum;
    }

    /**
     * Returns the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the ZIP code.
     */
    public String getZipCode() {
        return zipCode;
    }
}