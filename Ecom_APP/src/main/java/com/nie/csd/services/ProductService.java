package com.nie.csd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.nie.csd.models.Products;
import com.nie.csd.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Products addProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(Products product) {
        Products exProduct = productRepository.findById(product.getId()).orElse(null);
        if (exProduct != null) {
            exProduct.setName(product.getName());
            exProduct.setDescription(product.getDescription());
            exProduct.setPrice(product.getPrice());
            exProduct.setCategory(product.getCategory());
            return productRepository.save(exProduct);
        }
        return null;

    }
    public void deleteProduct(String id) {
        Products exProduct = productRepository.findById(id).orElse(null);
        if (exProduct != null) {
            productRepository.delete(exProduct);
            System.out.println("Product with id " + id + " deleted successfully.");
        } else {
            System.out.println("Product with id " + id + " not found.");
        }
    }

}
