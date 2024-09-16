package com.gd.gdfood_api.api.V1.domain.restaurant;

import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String image;
    private String category;
    private BigDecimal stars;

    public Restaurant(RestaurantDTO restaurant){
        this.name = restaurant.name();
        this.address = restaurant.address();
        this.phoneNumber = restaurant.phoneNumber();
        this.image = restaurant.image();
        this.category = restaurant.category();
        this.stars = BigDecimal.valueOf(0.0);
    }


}
