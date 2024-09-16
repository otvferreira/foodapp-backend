package com.gd.gdfood_api.api.V1.controllers;

import com.gd.gdfood_api.api.V1.domain.user.User;
import com.gd.gdfood_api.api.V1.domain.user.dto.LoginRequestDTO;
import com.gd.gdfood_api.api.V1.domain.user.dto.ResponseDTO;
import com.gd.gdfood_api.api.V1.domain.user.dto.UserDTO;
import com.gd.gdfood_api.api.V1.infra.security.TokenService;
import com.gd.gdfood_api.api.V1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/V1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO body){
        Optional<User> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());
            newUser.setEnable(true);
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
