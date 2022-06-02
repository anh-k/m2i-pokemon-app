package com.formation.pokemonapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.entity.Team;
import lombok.Data;

@Data
public class PokemonDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("baseExp")
    private int baseExp;

    public Pokemon convertToEntity() {
        return Pokemon.builder()
                .id(id)
                .name(name)
                .baseExp(baseExp)
                .build();
    }
}
