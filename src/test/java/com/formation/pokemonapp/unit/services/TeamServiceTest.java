package com.formation.pokemonapp.unit.services;

import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.errors.ApplicationException;
import com.formation.pokemonapp.repository.TeamRepository;
import com.formation.pokemonapp.service.impl.PokemonServiceImpl;
import com.formation.pokemonapp.service.impl.TeamServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DataJpaTest
@DisplayName("Team service should")
public class TeamServiceTest {
    private TeamServiceImpl teamService;
    private PokemonServiceImpl pokemonService;
    @Mock
    private TeamRepository teamRepository;
    @Captor
    ArgumentCaptor<Team> teamCaptor;

    private Team team;

    @BeforeEach
    void setUp() {
        teamService = new TeamServiceImpl(teamRepository, pokemonService);
        team = Team.builder()
                .id(1)
                .name("team1")
                .pokemons(getPokemonSet())
                .build();
    }

    @Test
    @DisplayName("throw null pointer exception")
    void nullData() {
        assertThatThrownBy(() -> teamService.saveTeam(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("save team succesfully")
    void goodData() throws ApplicationException {
        teamService.saveTeam(team);
        verify(teamRepository).save(teamCaptor.capture());
        assertThat(teamCaptor.getValue().getId()).isEqualTo(1);
        assertThat(teamCaptor.getValue().getName()).isEqualTo("team1");
        assertThat(teamCaptor.getValue().getPokemons()).hasSize(3);
        verifyNoMoreInteractions(teamRepository);
    }

    private Set<Pokemon> getPokemonSet() {
        Pokemon pokemonOne = Pokemon.builder()
                .id(1)
                .name("one")
                .baseExp(64)
                .build();
        Pokemon pokemonTwo = Pokemon.builder()
                .id(2)
                .name("two")
                .baseExp(64)
                .build();
        Pokemon pokemonThree = Pokemon.builder()
                .id(3)
                .name("three")
                .baseExp(64)
                .build();

        return Stream.of(pokemonOne, pokemonTwo, pokemonThree).collect(Collectors.toSet());
    }
}
