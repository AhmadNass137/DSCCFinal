package com.example.Catalog.models;

public class TransactionCost {
    String id;
    Double cost;

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.cost = amount;
    }

    public Double getCost() {
        return cost;
    }

    public String getId() {
        return id;
    }

    public TransactionCost() {}

    public TransactionCost(String id, Double cost) {
        this.id = id;
        this.cost = cost;
    }
}
