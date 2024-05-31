package com.example.Catalog.models;

import java.util.ArrayList;

public class SystemProducts {
    //any product created should be added by default into this array for the hole system
     static ArrayList<Product> Products= new ArrayList<>();

    public SystemProducts() {
        Products.add(new Product("I1","coca-cola",400.0,3));
        Products.add(new Product("I2","pen",200.0,10));
        Products.add(new Product("I11","laptop",4000.0,4));
        Products.add(new Product("I22","notebook",20.0,8));
        Products.add(new Product("I111","ahmad",400.0,1));
        Products.add(new Product("I222","girl in the mirror",200.0,6));
    }

    public Product getProduct(String id) {
        for (int i = 0; i < this.Products.size(); i++) {
            if(this.Products.get(i).getId().equals(id) ){
                return this.Products.get(i);
            }
        }
        return null;
    }

    public void addSystemProduct(Product p){ Products.add(p);}

    public void updateAmount(String id, int amount) {
        for (int i = 0; i < this.Products.size(); i++)
            if (Products.get(i).getId().equals(id))
                Products.get(i).updateCount(amount);
    }

}
