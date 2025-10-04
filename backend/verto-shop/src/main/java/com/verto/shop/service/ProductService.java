package com.verto.shop.service;

import com.verto.shop.model.Product;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ProductService {

    // Thread-safe list for demo-only in-memory catalog
    private final List<Product> products = new CopyOnWriteArrayList<>();

    // Optional base URL .  
    @Value("${app.base-url:}")
    private String baseUrl;

@PostConstruct
    private void initCatalog() {
        // Use relative paths that are served from src/main/resources/static/images
        products.add(new Product("p_001", "Wireless Mouse", "Compact wireless mouse", 5000, buildImageUrl("/images/mouse.jpg"), "INR"));
        products.add(new Product("p_002", "Mechanical Keyboard", "Tactile mechanical keyboard", 9000, buildImageUrl("/images/keyboard.jpg"), "INR"));
        products.add(new Product("p_003", "USB-C Hub", "5-in-1 hub", 8000, buildImageUrl("/images/hub.jpg"), "INR"));
        products.add(new Product("p_004", "Headphones", "Noise cancelling headphones", 8999, buildImageUrl("/images/headphones.jpg"), "INR"));
        products.add(new Product("p_005", "Laptop Stand", "Aluminum stand", 9500, buildImageUrl("/images/stand.jpg"), "INR"));
    }

     private String buildImageUrl(String path) {
        if (baseUrl == null || baseUrl.isBlank()) return path;
        String trimmed = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        return trimmed + path;
    }

    public List<Product> getAll() { return products; }

    public Optional<Product> findById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
