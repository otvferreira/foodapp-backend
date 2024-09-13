package com.gd.gdfood_api.api.V1.controllers;

import com.gd.gdfood_api.api.V1.domain.product.Product;
import com.gd.gdfood_api.api.V1.domain.product.dto.ProductDTO;
import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import com.gd.gdfood_api.api.V1.services.ProductService;
import com.gd.gdfood_api.api.V1.services.RestaurantService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/product/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService service){
        this.productService = service;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO){
        Product product = this.productService.create(productDTO);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listAll() {
        List<Product> products = this.productService.listAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<Product> alter(@PathParam("id") Long id, @RequestBody ProductDTO productDTO){
        Product alteredProduct = this.productService.alter(id, productDTO);
        return ResponseEntity.ok().body(alteredProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> delete(@PathParam("id") Long id){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
