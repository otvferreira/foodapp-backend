package com.gd.gdfood_api.api.V1.domain.product.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String mensagem){
        super(mensagem);
    }

    public ProductNotFoundException(Long id){
        this(String.format("O ID de produto fornecido não foi encontrado na base de dados. ID %d", id));
    }
}
