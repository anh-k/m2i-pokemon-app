package com.formation.pokemonapp.unit.repositories;

import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.repository.PokemonRepository;
import com.formation.pokemonapp.repository.TeamRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Team repository should")
public class TeamRepositoryTest {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    PokemonRepository pokemonRepository;

    @Test
    @DisplayName("get no existing team")
    void getTeam() {
        List<Team> teams = teamRepository.findAll();
        assertThat(teams).isEmpty();
    }

    @Test
    @DisplayName("save team with only one pokemon")
    void saveTeamWithEmptyPokemonList() {
        Team team = Team.builder()
                .id(1)
                .name("teamTest")
                .pokemons(Collections.EMPTY_SET)
                .build();

        teamRepository.save(team);
        assertThat(teamRepository.findAll()).hasSize(1);
        assertThat(pokemonRepository.findAll()).isEmpty();
    }

    @Test
    @DisplayName("save team with multiple pokemon")
    void saveTeamWithMultiplePokemon() {
        Pokemon pokemonOne = Pokemon.builder()
                .id(1)
                .name("PIKA")
                .baseExp(64)
                .build();
        Pokemon pokemonTwo = Pokemon.builder()
                .id(2)
                .name("FLAGA")
                .baseExp(64)
                .build();
        Pokemon pokemonThree = Pokemon.builder()
                .id(3)
                .name("TAUPI")
                .baseExp(64)
                .build();

        Set<Pokemon> pokemonSet = Stream.of(pokemonOne, pokemonTwo, pokemonThree).collect(Collectors.toSet());

        Team team = Team.builder()
                .id(1)
                .name("teamTest")
                .pokemons(pokemonSet)
                .build();

        teamRepository.save(team);
        assertThat(teamRepository.findAll()).hasSize(1);
        assertThat(pokemonRepository.findAll()).hasSize(3);
    }

}
