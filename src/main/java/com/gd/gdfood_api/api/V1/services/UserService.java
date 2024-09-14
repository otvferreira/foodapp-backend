package com.gd.gdfood_api.api.V1.services;

import com.gd.gdfood_api.api.V1.domain.user.User;
import com.gd.gdfood_api.api.V1.domain.user.dto.UserDTO;
import com.gd.gdfood_api.api.V1.domain.user.dto.UserNoPasswordDTO;
import com.gd.gdfood_api.api.V1.domain.user.exceptions.UserNotFoundException;
import com.gd.gdfood_api.api.V1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public User create(UserDTO userDTO){
        User user = new User(userDTO);
        this.repository.save(user);
        return user;
    }

    public List<User> findAll(){
        return this.repository.findAll();
    }

    public User find(String email){
        User user = this.repository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return user;
    }

    public User alter(String email, UserNoPasswordDTO userDTO){
        User alterUser = this.repository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        if(!userDTO.name().isEmpty())
            alterUser.setName(userDTO.name());
        if(!userDTO.email().isEmpty())
            alterUser.setEmail(userDTO.email());
        if(!userDTO.phoneNumber().isEmpty())
            alterUser.setPhoneNumber(userDTO.phoneNumber());

        this.repository.save(alterUser);
        return alterUser;
    }

}
