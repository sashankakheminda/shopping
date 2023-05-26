package com.example.shopping.controller;

import com.example.shopping.model.Product;
import com.example.shopping.service.ShoppingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAvailableProducts() {
        ResponseEntity<List<Product>> products = shoppingService.getAvailableProducts();
        return ResponseEntity.ok(products.getBody());
    }


}
