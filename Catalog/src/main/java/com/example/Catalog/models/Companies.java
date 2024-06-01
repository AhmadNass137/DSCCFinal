package com.example.Catalog.models;

import java.util.ArrayList;

public class Companies {
    ArrayList<Company> companies;

    public ArrayList<Company> getCompanies() {
        return companies;
    }
    public Company getCompany(String id) {
        for (Company company : companies)
            if (company.getId().equals(id))
                return company;
        return null;
    }
    public void addCompany(Company company){
        this.companies.add(company);
    }
    public Companies() {
        ArrayList<Product> apple_products = new ArrayList<>();
        apple_products.add(new Product("P1", "iPhone", 100.0, 100));
        apple_products.add(new Product("P1", "iPad", 100.0, 100));
        ArrayList<CompanyService> apple_services = new ArrayList<>();
        apple_services.add(new CompanyService(101,"iCloud", 10.0));
        companies = new ArrayList<>();
        companies.add(new Company("B1", "Apple", 200000.0, apple_products, apple_services));
        companies.add(new Company("B2", "Lamborghini", 300000.0));
        companies.add(new Company("B3", "Sketch", 400000.0));
        companies.add(new Company("B4", "360", 500000.0));
        companies.add(new Company("B5", "Coffesta", 600000.0));
        companies.add(new Company("B6", "Romba", 700000.0));
        companies.add(new Company("B7", "Topsi", 800000.0));
    }

    void updateBudget(String id, Double amount) {
        for (Company company : companies)
            if (company.getName().equals(id)) {
                company.updateBudget(amount);
                break;
            }
    };
}
