package com.example.Catalog.models;

import java.util.ArrayList;

public class Customer {
    String id;
    String name;
    Double budget;
    ArrayList<Product> products;

    public Customer(){

    }
    public Customer(String id, String name, Double budget){
        this.id = id;
        this.name = name;
        this.budget = budget;
    }
    public Customer(String id, String name, Double budget, ArrayList<Product> products){
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.products = products;
    }
    public void updateBudget(Double amount) {
        this.budget += amount;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}
