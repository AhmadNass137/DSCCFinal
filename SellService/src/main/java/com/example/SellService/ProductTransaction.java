package com.example.SellService;

public class ProductTransaction {
    String providerID;
    Product product;

    public Product getProduct() {
        return product;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public ProductTransaction(String providerID, Product product){
            this.providerID = providerID;
            this.product = product;
    }
}
