package com.gd.gdfood_api.api.V1.repositories;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findById(Long id);
    List<Restaurant> findByNameContainingIgnoreCase(String name);
}
