/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Rushabh
 */
public class Product {
    
    private String name;
    private int price;
    private int id;
    // Stores the features associated with this product
private ArrayList<Feature> features = new ArrayList<>();
    private static int count = 0;
    
    public Product() {
        count++;
        id = count;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    @Override
    public String toString() {
        return name;
    }
    
   /**
 * Returns all features associated with this product.
 */
public ArrayList<Feature> getFeatures() {
    return features;
}

/**
 * Adds a new feature to this product.
 */
public void addFeature(String name, String value) {
    Feature feature = new Feature(name, value);
    features.add(feature);
}

/**
 * Removes the specified feature from this product.
 */
public void removeFeature(Feature feature) {
    features.remove(feature);
} 
}
