package com.example.Catalog;

import com.example.Catalog.models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    SystemcompanyProducts defaultCompaniesProducts = new SystemcompanyProducts();
    SystemProducts defalutSystemProducts = new SystemProducts();
    Companies companies = new Companies();
    Customers customers = new Customers();
    @GetMapping("/GetItemIdPrice/{productID}")
    public double getItemPrice(@PathVariable String productID) {
        Product ans = defalutSystemProducts.getProduct(productID);
        return ans.getPrice();
    }

    @PostMapping("/updateProduct")
    public void updateProductAmount(@RequestBody Transaction transaction) {
        System.out.println("Before: " + defalutSystemProducts.getProduct(transaction.getId()).getCount());
        defalutSystemProducts.updateAmount(transaction.getId(), transaction.getAmount());
        System.out.println("After: " + defalutSystemProducts.getProduct(transaction.getId()).getCount());
    }

    @PostMapping("/update-budget")
    public void updateBudget(@RequestBody TransactionCost transaction) {
        System.out.println(transaction.getCost());
        char type = transaction.getId().charAt(0);
        switch (type) {
            case 'B':
               for (Company company : companies.getCompanies())
                   if (company.getId().equals(transaction.getId())) {
                       System.out.println("Before: " + company.getBudget());
                       company.updateBudget(transaction.getCost());
                       System.out.println("After: " + company.getBudget());
                   }
               break;
            case 'C':
                for (Customer customer : customers.getCustomers())
                    if (customer.getId().equals(transaction.getId())) {
                        System.out.println(transaction.getCost());
                        System.out.println("Before: " + customer.getBudget());
                        customer.updateBudget(transaction.getCost());
                        System.out.println("After: " + customer.getBudget());
                    }
                break;
            default:
                break;
        }
    }
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductTransaction transaction) {
        defalutSystemProducts.addSystemProduct(transaction.getProduct());
        System.out.println("Added Product " + transaction.getProduct().getName());
        defaultCompaniesProducts.addcompanyproduct(transaction.getProduct(),transaction.getProviderID());
    }
}
