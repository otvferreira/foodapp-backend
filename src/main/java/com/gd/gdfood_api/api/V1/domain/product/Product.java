package com.gd.gdfood_api.api.V1.domain.product;

import com.gd.gdfood_api.api.V1.domain.product.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private Float value;
    private Long restaurantId;
    private boolean enable;
    private String image;

    public Product(ProductDTO productDTO){
        this.name = productDTO.name();
        this.description = productDTO.description();
        this.value = productDTO.value();
        this.restaurantId = productDTO.restId();

    }

    public void activate(){
        if(this.enable) {
            this.enable = false;
        } else {
            this.enable = true;
        }
    }
}
