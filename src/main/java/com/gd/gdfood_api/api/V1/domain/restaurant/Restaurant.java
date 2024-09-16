package com.gd.gdfood_api.api.V1.domain.restaurant;

import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String userID;

    public Restaurant(RestaurantDTO restaurant){
        this.name = restaurant.name();
        this.address = restaurant.address();
        this.phoneNumber = restaurant.phoneNumber();
    }


}
