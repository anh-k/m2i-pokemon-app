package com.formation.pokemonapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.formation.pokemonapp.entity.Pokemon;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class PokemonDTO {
    @Positive
    @JsonProperty("id")
    private long id;

    @NotBlank
    @JsonProperty("name")
    private String name;

    @Positive
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
