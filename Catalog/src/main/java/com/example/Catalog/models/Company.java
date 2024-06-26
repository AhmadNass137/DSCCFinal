package com.example.Catalog.models;

import java.util.ArrayList;

public class Company {
    String id;
    String name;
    ArrayList<Product> products;
    ArrayList<CompanyService> services;
    Double budget ;

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public ArrayList<CompanyService> getServices() {
        return services;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setServices(ArrayList<CompanyService> services) {
        this.services = services;
    }

    public Company(){
    }
    public Company(String id, String name){
        this.id = id;
        this.name = name;
    }
    public Company(String id, String name, Double budget){
        this.id = id;
        this.name = name;
        this.budget = budget;
    }
    public Company(String id, String name, double budget, ArrayList<Product> products, ArrayList<CompanyService> services){
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.products = products;
        this.services = services;
    }
    public void updateBudget(Double amount) {
        this.budget += amount;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
