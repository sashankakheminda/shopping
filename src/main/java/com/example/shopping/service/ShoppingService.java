package com.example.shopping.service;

import com.example.shopping.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ShoppingService {
    private final RestTemplate restTemplate;

    public ShoppingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${urlendpoint.getAvailableProducts}")
    private String getAvailableProducts;

    public ResponseEntity<List<Product>> getAvailableProducts() {
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                getAvailableProducts,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );

        List<Product> products = responseEntity.getBody();

        return ResponseEntity.ok(products);
    }
}
