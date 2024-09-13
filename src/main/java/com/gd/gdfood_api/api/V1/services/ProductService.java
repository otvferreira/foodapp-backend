package com.gd.gdfood_api.api.V1.services;

import com.gd.gdfood_api.api.V1.domain.product.Product;
import com.gd.gdfood_api.api.V1.domain.product.dto.ProductDTO;
import com.gd.gdfood_api.api.V1.domain.product.exceptions.ProductNotFoundException;
import com.gd.gdfood_api.api.V1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product create(ProductDTO productDTO){
        Product product = new Product(productDTO);
        this.repository.save(product);
        return product;
    }

    public List<Product> listAll(){
        return this.repository.findAll();
    }

    public Product find(Long id){
        return this.repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product alter(Long id, ProductDTO productDTO){
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        if(!productDTO.name().isEmpty())
            product.setName(productDTO.name());
        if (!productDTO.description().isEmpty())
            product.setDescription(productDTO.description());
        //if (productDTO.value() != null)
        //    product.setValue(productDTO.value());

        this.repository.save(product);
        return product;
    }

    public void delete(Long id){
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        this.repository.delete(product);
    }
}
