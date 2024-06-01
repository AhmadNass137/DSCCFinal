package com.example.Catalog;

import com.example.Catalog.models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    SystemcompanyProducts defaultCompaniesProducts = new SystemcompanyProducts();
    SystemProducts defalutSystemProducts = new SystemProducts();
    Companies companies = new Companies();
    @GetMapping("/GetItemIdPrice/{productID}")
    public double getItemPrice(@PathVariable String productID) {
        Product ans = defalutSystemProducts.getProduct(productID);
        return ans.getPrice();
    }

    @PostMapping("/update")
    public void receiveString(@RequestBody Transaction transaction) {
        System.out.println("Before: " + defalutSystemProducts.getProduct(transaction.getId()).getCount());
        defalutSystemProducts.updateAmount(transaction.getId(), transaction.getAmount());
        System.out.println("After: " + defalutSystemProducts.getProduct(transaction.getId()).getCount());
    }
}
