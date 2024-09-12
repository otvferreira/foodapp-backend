package com.gd.gdfood_api.api.V1.controllers;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import com.gd.gdfood_api.api.V1.services.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/restaurant")
public class RestaurantController {

    private RestaurantService service;

    public RestaurantController(RestaurantService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody RestaurantDTO restaurantDTO){
        Restaurant restaurant = this.service.create(restaurantDTO);
        return ResponseEntity.ok().body(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> listAll() {
        List<Restaurant> restaurants = this.service.listAll();
        return ResponseEntity.ok().body(restaurants);
    }

}
