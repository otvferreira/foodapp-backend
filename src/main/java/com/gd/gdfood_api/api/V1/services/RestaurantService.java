package com.gd.gdfood_api.api.V1.services;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import com.gd.gdfood_api.api.V1.domain.restaurant.exceptions.RestaurantNotFoundException;
import com.gd.gdfood_api.api.V1.domain.user.User;
import com.gd.gdfood_api.api.V1.domain.user.exceptions.UserNotFoundException;
import com.gd.gdfood_api.api.V1.repositories.RestaurantRepository;
import com.gd.gdfood_api.api.V1.repositories.UserRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private RestaurantRepository repository;

    @Autowired
    private UserRepository userRepository;

    public RestaurantService(RestaurantRepository repository){
        this.repository = repository;
    }

    public Restaurant create(String userEmail, RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant(restaurantDTO);

        User user = this.userRepository.findByEmail(userEmail)
                .orElseThrow(UserNotFoundException::new);

        this.repository.save(restaurant);

        if(user.getRestaurant() != null){
            throw new RuntimeException("Usuário já possui um restaurante cadastrado.");
        } else {
            user.setRestaurant(restaurant.getId());
            this.userRepository.save(user);
        }
        return restaurant;
    }

    public List<Restaurant> listAll(String search) {
        if (search == null || search.isEmpty()) {
            return repository.findAll();
        } else {
            return repository.findByNameContainingIgnoreCase(search);
        }
    }

    public Restaurant find(Long id) {
            return repository.findById(id)
                    .orElseThrow(() -> new RestaurantNotFoundException(id));

    }

    public Restaurant alter(Long id, RestaurantDTO restaurantDTO){
        Restaurant alterRestaurant = this.repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        if(!restaurantDTO.name().isEmpty())
            alterRestaurant.setName(restaurantDTO.name());
        if(!restaurantDTO.address().isEmpty())
            alterRestaurant.setAddress(restaurantDTO.address());
        if(!restaurantDTO.phoneNumber().isEmpty())
            alterRestaurant.setPhoneNumber(restaurantDTO.phoneNumber());
        if(!restaurantDTO.category().isEmpty())
            alterRestaurant.setCategory(restaurantDTO.category());

        this.repository.save(alterRestaurant);
        return alterRestaurant;
    }

    public void delete(Long id){
        Restaurant alterRestaurant = this.repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        User user = this.userRepository.findByRestaurant(id)
                .orElseThrow();
        user.userRestaurant();
        this.userRepository.save(user);

        this.repository.delete(alterRestaurant);
    }

}
