package com.gd.gdfood_api.api.V1.domain.user.exceptions;

public class UserEmailAlreadyExist extends RuntimeException{
    public UserEmailAlreadyExist(String mensagem){
        super(mensagem);
    }

    public UserEmailAlreadyExist(){
        this("Email informado já existe na base de dados.");
    }
}
