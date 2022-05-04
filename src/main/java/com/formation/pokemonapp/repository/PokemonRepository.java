package com.formation.pokemonapp.repository;

import com.formation.pokemonapp.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Set<Pokemon> getAllByTeam(@Param("teamId") long teamId);

    @Query("select p from Pokemon p where p.id in :pokemonsId")
    Set<Pokemon> getAllByPokemonsId(@Param("pokemonsId") Set<Long> pokemonsId);
}
