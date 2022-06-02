package com.formation.pokemonapp.unit.repositories;

import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.repository.PokemonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Pokemon repository should")
public class PokemonRepositoryTest {
    @Autowired
    PokemonRepository pokemonRepository;

    @Test
    @DisplayName("get no existing pokemon")
    void getPokemon() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        assertThat(pokemons).isEmpty();
    }

    @Test
    @DisplayName("save pokemon successfully")
    void saveOnePokemon() {
        Pokemon pokemon = Pokemon.builder()
                .id(0)
                .name("test")
                .baseExp(64)
                .build();

        pokemonRepository.save(pokemon);
        assertThat(pokemonRepository.findAll()).hasSize(1);
    }

    @Test
    @DisplayName("save multiple pokemon successfully")
    void saveMultiplePokemon() {
        Pokemon pokemonOne = Pokemon.builder()
                .id(4)
                .name("DRAC")
                .baseExp(64)
                .build();
        Pokemon pokemonTwo = Pokemon.builder()
                .id(5)
                .name("TORT")
                .baseExp(64)
                .build();
        Pokemon pokemonThree = Pokemon.builder()
                .id(6)
                .name("FLORI")
                .baseExp(64)
                .build();

        Set<Pokemon> pokemonSet = Stream.of(pokemonOne, pokemonTwo, pokemonThree).collect(Collectors.toSet());
        pokemonRepository.saveAll(pokemonSet);
        assertThat(pokemonRepository.findAll()).hasSize(3);
    }

}
