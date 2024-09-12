package com.gd.gdfood_api.api.V1.services;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import com.gd.gdfood_api.api.V1.repositories.RestaurantRepository;
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


}
