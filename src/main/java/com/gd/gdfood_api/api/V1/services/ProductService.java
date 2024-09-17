package com.gd.gdfood_api.api.V1.services;

import com.gd.gdfood_api.api.V1.domain.product.Product;
import com.gd.gdfood_api.api.V1.domain.product.dto.ProductDTO;
import com.gd.gdfood_api.api.V1.domain.product.exceptions.ProductNotFoundException;
import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import com.gd.gdfood_api.api.V1.domain.restaurant.exceptions.RestaurantNotFoundException;
import com.gd.gdfood_api.api.V1.repositories.ProductRepository;
import com.gd.gdfood_api.api.V1.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Product create(ProductDTO productDTO){
        Restaurant restaurant = restaurantRepository.findById(productDTO.restaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurante não encontrado"));

        Product product = new Product(productDTO, restaurant);
        this.repository.save(product);

        return product;
    }

    public List<Product> listAll(){
        return this.repository.findAll();
    }

    public List<Product> findAll(Long id, String typeFood) {
        if (typeFood == null || typeFood.isEmpty()) {
            return this.repository.findByRestaurant_Id(id)
                    .orElseThrow(() -> new RestaurantNotFoundException("Restaurante não encontrado"));
        } else {
            return this.repository.findByRestaurant_IdAndTypeFood(id, typeFood)
                    .orElseThrow(() -> new RestaurantNotFoundException("Restaurante não encontrado"));
        }
    }


    public Product alter(Long id, ProductDTO productDTO){

        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));


        if (!productDTO.name().isEmpty()) {
            product.setName(productDTO.name());
        }
        if (!productDTO.description().isEmpty()) {
            product.setDescription(productDTO.description());
        }
        if (productDTO.price() != null) {
            product.setPrice(productDTO.price());
        }

        if (productDTO.restaurantId() != null && !productDTO.restaurantId().equals(product.getRestaurant().getId())) {
            Restaurant newRestaurant = restaurantRepository.findById(productDTO.restaurantId())
                    .orElseThrow(() -> new RestaurantNotFoundException("Restaurante não encontrado"));
            product.setRestaurant(newRestaurant);
        }

        this.repository.save(product);
        return product;
    }

    public void delete(Long id){
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        this.repository.delete(product);
    }
}
