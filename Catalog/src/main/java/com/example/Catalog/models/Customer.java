package com.example.Catalog.models;

import java.util.ArrayList;

public class Customer {
    int id;
    String name;
    Double budget;
    ArrayList<Product> products;

    public Customer(){

    }
    public Customer(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Customer(int id, String name, ArrayList<Product> products){
        this.id = id;
        this.name = name;
        this.products = products;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}
