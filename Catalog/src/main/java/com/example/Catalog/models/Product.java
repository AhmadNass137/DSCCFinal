package com.example.Catalog.models;

public class Product {

    String  id;
    String name;
    Double price;
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product(String id, String name, Double price,int count){
        this.id = id;
        this.name = name;
        this.price = price;
        this.count= count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice( ) {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void updateCount(int amount) { this.count -= amount; }
}
