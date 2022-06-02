package com.formation.pokemonapp.service;

import com.formation.pokemonapp.dto.PokemonDTO;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.errors.ApplicationException;
import lombok.NonNull;

import java.util.Optional;
import java.util.Set;

public interface PokemonService {

    /**
     * Récupération des pokemons en fonction de leur id
     */
    Set<Pokemon> findByIds(Set<Long> pokemonsId);

    /**
     * Récupération des pokemons
     */
    Set<PokemonDTO> convertPokemonToDTO(Set<Pokemon> pokemons);

    /**
     * Création ou modification d'un pokemon
     */
    Pokemon savePokemon(@NonNull Pokemon pokemon) throws ApplicationException;

    /**
     * Récupération d'un pokemon en fonction de son id
     */
    Optional<Pokemon> findById(Long pokemonId);

    /**
     * Récupération d'un pokemonDTO en fonction de son id
     */
    PokemonDTO getPokemonDTO(long id) throws ApplicationException;
}
