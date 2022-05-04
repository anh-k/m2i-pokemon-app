package com.formation.pokemonapp.service;

import com.formation.pokemonapp.dto.PokemonDTO;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.input.PokemonInput;

import java.util.Set;

public interface PokemonService {
    /**
     * Récupération des pokemons en fonction de l'id de la team
     */
    Set<PokemonDTO> getPokemonsByTeam(long idTeam);

    /**
     * Récupération des pokemons en fonction de leur id
     */
    Set<Pokemon> findByIds(Set<Long> pokemonsId);

    /**
     * Création ou modification d'un pokemon
     */
    Pokemon createOrUpdate(final PokemonInput pokemonInput);
}
