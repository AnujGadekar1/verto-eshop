// PATH: src/main/java/com/verto/shop/controller/ProductController.java
package com.verto.shop.controller;

import com.verto.shop.model.Product;
import com.verto.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService svc;

    public ProductController(ProductService svc) {
        this.svc = svc;
    }

    // Core Feature: GET /api/products
    // Returns the hardcoded JSON list of products.
    @GetMapping
    public List<Product> list() {
        return svc.getAll();
    }
}