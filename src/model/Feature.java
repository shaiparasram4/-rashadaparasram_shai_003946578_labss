/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author archil
 */
public class Feature {
      private String name;
    private String value;

    // Constructor to create a product feature
    public Feature(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // Return the feature name
    public String getName() {
        return name;
    }

    // Update the feature name
    public void setName(String name) {
        this.name = name;
    }

    // Return the feature value
    public String getValue() {
        return value;
    }

    // Update the feature value
    public void setValue(String value) {
        this.value = value;
    }

    // Provide a readable representation
    @Override
    public String toString() {
        return name + ": " + value;
    }
}


