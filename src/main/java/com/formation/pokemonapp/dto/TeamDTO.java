package com.formation.pokemonapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TeamDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

//    @JsonProperty("user")
//    private UserDTO user;

//    @JsonProperty("pokemons")
//    private set<PokemonDTO> pokemons;
}
