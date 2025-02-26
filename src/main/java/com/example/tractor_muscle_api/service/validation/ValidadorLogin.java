package com.example.tractor_muscle_api.service.validation;

public class ValidadorLogin  extends RuntimeException {

    public ValidadorLogin(String mensagem){
        super(mensagem);
    }

}
