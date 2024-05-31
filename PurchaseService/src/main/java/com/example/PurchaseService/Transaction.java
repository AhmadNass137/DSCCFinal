package com.example.PurchaseService;

public class Transaction {
    String id;
    int amount;

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public Transaction() {}

    public Transaction(String id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
