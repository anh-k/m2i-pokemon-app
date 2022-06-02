package com.formation.pokemonapp.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApplicationException extends Exception{

    private HttpStatus httpStatus;
    public ApplicationException(String message) {
        super(message);
     //   this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
