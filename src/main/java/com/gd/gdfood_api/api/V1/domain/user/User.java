package com.gd.gdfood_api.api.V1.domain.user;

import com.gd.gdfood_api.api.V1.domain.user.dto.UserDTO;
import com.gd.gdfood_api.api.V1.domain.user.dto.UserNoPasswordDTO;
import com.gd.gdfood_api.api.V1.domain.user.dto.UserRestaurantDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String image;
    private String phoneNumber;
    private boolean enable;
    private Long restaurant;

    public User(UserDTO userDTO){
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.image = userDTO.image();
        this.phoneNumber = userDTO.phoneNumber();
        this.enable = true;
    }

    public User(UserNoPasswordDTO userNoPasswordDTO){
        this.name = userNoPasswordDTO.name();
        this.email = userNoPasswordDTO.email();
        this.image = userNoPasswordDTO.image();
        this.phoneNumber = userNoPasswordDTO.phoneNumber();
        this.enable = true;
    }

    public void userRestaurant(UserRestaurantDTO userRestaurantDTO){
        this.restaurant = userRestaurantDTO.restaurantID();
    }

    public void enableDisable(){
        if(!this.enable){
            this.enable = false;
        } else {
            this.enable = true;
        }
    }
}
