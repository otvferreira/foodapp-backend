package com.gd.gdfood_api.api.V1.domain.product;

import com.gd.gdfood_api.api.V1.domain.product.dto.ProductDTO;
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
    //private BigDecimal value;
    private String type;

    @Column(name = "restaurant_id")
    private Long restaurantId;
    private boolean enable;
    private String image;

    public Product(ProductDTO productDTO){
        this.name = productDTO.name();
        this.description = productDTO.description();
        //this.value = productDTO.value();
        this.restaurantId = productDTO.restaurantId();
        this.image  = productDTO.image();
        this.enable = true;
    }

    public void activate(){
        if(this.enable) {
            this.enable = false;
        } else {
            this.enable = true;
        }
    }
}
