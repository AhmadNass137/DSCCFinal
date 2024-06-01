package com.example.Catalog.models;

import java.util.ArrayList;

public class Customers {
    ArrayList<Customer> customers;

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer getCompany(String id) {
        for (Customer customer : customers)
            if (customer.getId().equals(id))
                return customer;
        return null;
    }
    public void addCompany(Customer customer){
        customers.add(customer);
    }
    public Customers() {
        ArrayList<Product> raghad_products = new ArrayList<>();
        raghad_products.add(new Product("R1", "Canva", 50.0, 100));
        customers = new ArrayList<>();
        customers.add(new Customer("C1", "Raghad", 200000.0, raghad_products));
        customers.add(new Customer("C2", "Tammam", 300000.0));
        customers.add(new Customer("C3", "Ahmad", 40000000.0));
        customers.add(new Customer("C4", "Amer", 500000.0));
    }

    void updateBudget(String id, Double amount) {
        for (Customer customer : customers)
            if (customer.getName().equals(id)) {
                customer.updateBudget(amount);
                break;
            }
    };
}
