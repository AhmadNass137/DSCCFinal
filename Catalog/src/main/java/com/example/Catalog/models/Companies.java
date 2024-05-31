package com.example.Catalog.models;

import java.util.ArrayList;

public class Companies {
    ArrayList<Company> companies;

    public ArrayList<Company> getCompanies() {
        return companies;
    }
    public Company getCompany(int id) {
        for (int i = 0; i < this.companies.size(); i++) {
            if(this.companies.get(i).getId() == id){
                return this.companies.get(i);
            }
        }
        return null;
    }
    public void addCompany(Company company){
        this.companies.add(company);
    }
    public Companies() {
        companies.add(new Company(1, "Apple", 200000.0));
        companies.add(new Company(2, "Lamborghini", 300000.0));
        companies.add(new Company(3, "Sketch", 400000.0));
        companies.add(new Company(4, "360", 500000.0));
        companies.add(new Company(5, "Coffesta", 600000.0));
        companies.add(new Company(6, "Romba", 700000.0));
        companies.add(new Company(7, "Topsi", 800000.0));
    }
}
