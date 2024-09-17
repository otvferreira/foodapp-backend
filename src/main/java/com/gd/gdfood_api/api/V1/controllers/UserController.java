package com.gd.gdfood_api.api.V1.controllers;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;
import com.gd.gdfood_api.api.V1.domain.user.User;
import com.gd.gdfood_api.api.V1.domain.user.dto.UserDTO;
import com.gd.gdfood_api.api.V1.domain.user.dto.UserNoPasswordDTO;
import com.gd.gdfood_api.api.V1.services.RestaurantService;
import com.gd.gdfood_api.api.V1.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/user/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = this.userService.findAll();
        return ResponseEntity.ok().body(users);
        // Trazendo password para mostrar na entrevista que está criptografado, em produção alterar para não retornar.

    }

    @GetMapping("/find/{email}")
    public ResponseEntity<User> find(@PathParam("email") String email){
        User user = this.userService.find(email);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/alter/{email}")
    public ResponseEntity<User> alter(@PathParam("email") String email, @RequestBody UserNoPasswordDTO userNoPasswordDTO){
        User alteredUser = this.userService.alter(email, userNoPasswordDTO);
        return ResponseEntity.ok().body(alteredUser); // 200 - Ok
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<User> delete(@PathParam("email") String email){
        this.userService.delete(email);
        return ResponseEntity.noContent().build();
    }

}
