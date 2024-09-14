package com.gd.gdfood_api.api.V1.domain.user.exceptions;



public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mensagem){
        super(mensagem);
    }

    public UserNotFoundException(){
        this("Usuario fornecido não foi encontrado na base de dados.");
    }
}
