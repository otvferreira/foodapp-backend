package com.gd.gdfood_api.api.V1.repositories;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
