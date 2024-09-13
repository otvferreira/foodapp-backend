package com.gd.gdfood_api.api.V1.services;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import com.gd.gdfood_api.api.V1.domain.restaurant.exceptions.RestaurantNotFoundException;
import com.gd.gdfood_api.api.V1.repositories.RestaurantRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository){
        this.repository = repository;
    }

    public Restaurant create(RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant(restaurantDTO);
        this.repository.save(restaurant);
        return restaurant;
    }

    public List<Restaurant> listAll(){
        return this.repository.findAll();
    }

    public Restaurant alter(Long id, RestaurantDTO restaurantDTO){
        Restaurant alterRestaurant = this.repository.findById(id)
                .orElseThrow(RestaurantNotFoundException::new);

        if(!restaurantDTO.name().isEmpty())
            alterRestaurant.setName(restaurantDTO.name());
        if(!restaurantDTO.address().isEmpty())
            alterRestaurant.setAddress(restaurantDTO.address());
        if(!restaurantDTO.phoneNumber().isEmpty())
            alterRestaurant.setPhoneNumber(restaurantDTO.phoneNumber());

        this.repository.save(alterRestaurant);
        return alterRestaurant;
    }

    public void delete(Long id){
        Restaurant alterRestaurant = this.repository.findById(id)
                .orElseThrow(RestaurantNotFoundException::new);

        this.repository.delete(alterRestaurant);
    }

}
