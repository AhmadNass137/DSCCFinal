package com.example.PurchaseService;

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
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.HashMap;

@RestController
@RequestMapping("/purchase")
public class PurchaseServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/send")
    public void sendTransaction(@RequestBody Transaction transaction) {
        System.out.println(transaction.getId() + "\t" + transaction.getAmount());
        String url = "http://localhost:8082/catalog/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Transaction> request = new HttpEntity<>(transaction, headers);
        String response = restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();
    }

    @GetMapping("/PurchaseService/from/{company1}/to/{company2}/item-number/{itemNum}/quantity/{quantity}")
    public PurchaseResponse calculatePurchaseBetweenCompanies(
            @PathVariable String company1,
            @PathVariable String company2,
            @PathVariable String quantity,
            @PathVariable String itemNum
    ) {

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("company1", company1);
        uriVariables.put("company2", company2);
        uriVariables.put("quantity", quantity);
        uriVariables.put("itemNum", itemNum);

        ResponseEntity<Double> responseEntityForPrice = new RestTemplate().getForEntity
                ("http://localhost:8082/catalog/GetItemIdPrice/{itemNum}",
                        Double.class, uriVariables);

        Double purchasecost = responseEntityForPrice.getBody();

        return new PurchaseResponse(1,
                company1, company2, purchasecost);
    }
}