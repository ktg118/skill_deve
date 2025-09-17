package com.nie.csd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.nie.csd.models.Products;
import com.nie.csd.services.ProductService;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductCollector {

    @Autowired
    private ProductService service;

    @GetMapping
    @ResponseBody
    public List<Products> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Products getByProductId(@PathVariable("id") String id){
        return service.getProductById(id);
    }

    @PostMapping
    @ResponseBody
    public Products addProduct(@RequestBody Products product) {
        return service.addProduct(product);
    }
    @PutMapping("product/{id}")
    public Products updateProduct(@PathVariable("id") String id, @RequestBody Products product) {
        product.setId(id);
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable("id") String id) {
        service.deleteProduct(id);
    }
}

