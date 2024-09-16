package com.gd.gdfood_api.api.V1.controllers;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import com.gd.gdfood_api.api.V1.services.RestaurantService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/restaurant/")
public class RestaurantController {

    private RestaurantService service;

    public RestaurantController(RestaurantService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestParam("userEmail") String userEmail, @RequestBody RestaurantDTO restaurantDTO){
        Restaurant restaurant = this.service.create(userEmail, restaurantDTO);
        return ResponseEntity.ok().body(restaurant);
    }

    @GetMapping
    public List<Restaurant> searchRestaurants(@RequestParam(required = false) String search) {
        return service.listAll(search);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Restaurant> findRestaurants(@PathVariable Long id) {
        Restaurant restaurant = service.find(id);
        return ResponseEntity.ok().body(restaurant);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<Restaurant> alter(@PathParam("id") Long id, @RequestBody RestaurantDTO restaurantDTO){
        Restaurant alteredRest = this.service.alter(id, restaurantDTO);
        return ResponseEntity.ok().body(alteredRest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Restaurant> delete(@PathParam("id") Long id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
