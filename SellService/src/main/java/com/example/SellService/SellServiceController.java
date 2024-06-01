package com.example.SellService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@RestController
@RequestMapping("/sell")
public class SellServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/send")
    public void sendProductTransaction(@RequestBody ProductTransaction transaction) {
        String url = "http://localhost:8082/catalog/addProduct";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductTransaction> request = new HttpEntity<>(transaction, headers);
        restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();
    }

    @GetMapping("/SellService/{providerID}/item-number/{itemID}/item-name/{name}/item-price/{price}/item-count/{count}")
    @CircuitBreaker(name = "AddProduct", fallbackMethod = "AddProductFallback")
    public ProductTransaction AddProduct(
            @PathVariable String providerID,
            @PathVariable String itemID,
            @PathVariable String name,
            @PathVariable String price,
            @PathVariable String count) {
        sendProductTransaction(new ProductTransaction(providerID, new Product(itemID, name, Double.parseDouble(price), Integer.parseInt(count))));
        return new ProductTransaction(providerID, new Product(itemID, name, Double.parseDouble(price), Integer.parseInt(count)));
    }

    public ProductTransaction AddProductFallback(Throwable e) {
        return null;
    }
}
