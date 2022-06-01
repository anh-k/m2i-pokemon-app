package com.formation.pokemonapp.exception.model;

public class UserNameExistException extends Exception{

    public UserNameExistException(String message) {
        super(message);
    }
}
