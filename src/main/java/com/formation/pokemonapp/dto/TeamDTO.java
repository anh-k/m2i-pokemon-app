package com.formation.pokemonapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.entity.Team;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class TeamDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

//    @JsonProperty("user")
//    private UserDTO user;

    @JsonProperty("pokemons")
    private Set<PokemonDTO> pokemons;

    public Team convertToEntity() {
        Set<Pokemon> pokemonSet = pokemons.stream().map(this::convertPokemon).collect(Collectors.toSet());

        return Team.builder()
                .id(id)
                .name(name)
                .pokemons(pokemonSet)
                .build();
    }

    private Pokemon convertPokemon(PokemonDTO pokemonDTO) {
        return Pokemon.builder()
                .id(pokemonDTO.getId())
                .name(pokemonDTO.getName())
                .baseExp(pokemonDTO.getBaseExp())
                .build();
    }
}
