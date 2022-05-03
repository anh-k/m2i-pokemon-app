package com.formation.pokemonapp.input;

import lombok.Data;

import java.util.Set;
@Data
public class TeamInput {

    private long id;

    private String name;

    private Set<Long> pokemonsId;
}
