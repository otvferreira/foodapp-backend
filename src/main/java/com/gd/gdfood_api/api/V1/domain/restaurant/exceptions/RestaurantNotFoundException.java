package com.gd.gdfood_api.api.V1.domain.restaurant.exceptions;

import com.gd.gdfood_api.api.V1.domain.restaurant.Restaurant;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(String mensagem){
        super(mensagem);
    }

    public RestaurantNotFoundException(Long id){
        this(String.format("O ID de restaurante fornecido não foi encontrado na base de dados. ID %d", id));
    }
}
