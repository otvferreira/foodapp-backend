package com.gd.gdfood_api.api.V1.domain.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gd.gdfood_api.api.V1.domain.product.Product;
import com.gd.gdfood_api.api.V1.domain.restaurant.dto.RestaurantDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Restaurant(RestaurantDTO restaurant){
        this.name = restaurant.name();
        this.address = restaurant.address();
        this.phoneNumber = restaurant.phoneNumber();
        this.image = restaurant.image();
        this.category = restaurant.category();
        this.stars = BigDecimal.valueOf(0.0);
    }
}
