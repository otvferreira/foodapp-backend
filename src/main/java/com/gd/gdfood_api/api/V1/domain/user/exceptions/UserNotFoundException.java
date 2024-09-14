package com.gd.gdfood_api.api.V1.domain.user.exceptions;

import com.gd.gdfood_api.api.V1.domain.user.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mensagem){
        super(mensagem);
    }

    public UserNotFoundException(Long id){
        this(String.format("Usuario fornecido não foi encontrado na base de dados. ID %d", id));
    }

}
