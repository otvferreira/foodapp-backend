package com.gd.gdfood_api.api.V1.domain.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gd.gdfood_api.api.V1.domain.product.dto.ProductDTO;
import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String type;
    private boolean enable;
    private String image;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public Product(ProductDTO productDTO, Restaurant restaurant){
        this.name = productDTO.name();
        this.description = productDTO.description();
        this.restaurant = restaurant;
        this.price = productDTO.price();
        this.image  = productDTO.image();
        this.enable = true;
    }

    public void activate(){
        this.enable = !this.enable;
    }
}
