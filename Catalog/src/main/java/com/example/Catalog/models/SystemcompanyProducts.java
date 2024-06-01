package com.example.Catalog.models;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemcompanyProducts {
    private static  HashMap<String, ArrayList<String>> companyproducts= new HashMap<>() ;

    public SystemcompanyProducts() {
        ArrayList<String> company1= new ArrayList<>();
        company1.add("I1");
        company1.add("I2");
        ArrayList<String> company2= new ArrayList<>();
        company2.add("I11");
        company2.add("I22");
        ArrayList<String> company3= new ArrayList<>();
        company3.add("I111");
        company3.add("I222");
        companyproducts.put("c1",company1);
        companyproducts.put("c2",company2);
        companyproducts.put("c3",company3);
    }

    public void addcompanyproduct( Product product,String providerID){
        ArrayList<String> tempArray=new ArrayList<>();
        if(companyproducts.containsKey(providerID))
            tempArray.addAll(companyproducts.get(providerID));
        companyproducts.put(providerID,tempArray);
        System.out.println("New company Products "+ companyproducts.get(providerID));
    }

    public ArrayList<String> getCompanyproducts(String company_id) {
        return companyproducts.get(company_id);
    }

}
