package com.formation.pokemonapp.repository;

import com.formation.pokemonapp.dto.PokemonDTO;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Set<Pokemon> getPokemonsByTeamId(@Param("idTeam") long idTeam);

    @Query("select p from pokemon p where p.id in (:pokemonsId)")
    Set<Pokemon> getPokemonsById(@Param("pokemonsId") Set<Long> pokemonsId);
}
