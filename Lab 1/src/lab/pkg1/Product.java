/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg1;

/**
 *  Shai Rashada-Parasram
 * INFO 5100
 * 9/17/2026
 * Stores product information and its two addresses.
 * @author shai8
 */
public class Product {

    private String name;
    private String description;
    private int availNum;
    private double price;

    private Address manufactureAddress;
    private Address shippingAddress;

    /**
     * Creates an empty product.
     */
    public Product() {
    }

    /**
     * Creates a product with its details and addresses.
     */
    public Product(String name, String description,
                   int availNum, double price,
                   Address manufactureAddress,
                   Address shippingAddress) {

        this.name = name;
        this.description = description;
        this.availNum = availNum;
        this.price = price;
        this.manufactureAddress = manufactureAddress;
        this.shippingAddress = shippingAddress;
    }

    /**
     * Returns the product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the available quantity.
     */
    public int getAvailNum() {
        return availNum;
    }

    /**
     * Returns the product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the manufacturing address.
     */
    public Address getManufactureAddress() {
        return manufactureAddress;
    }

    /**
     * Returns the shipping address.
     */
    public Address getShippingAddress() {
        return shippingAddress;
    }
}
