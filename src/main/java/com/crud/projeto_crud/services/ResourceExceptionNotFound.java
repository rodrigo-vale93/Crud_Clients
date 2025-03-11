package com.crud.projeto_crud.services;

public class ResourceExceptionNotFound extends RuntimeException{

    public ResourceExceptionNotFound(String msg){
        super(msg);
    }
}
