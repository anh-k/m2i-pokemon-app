package com.formation.pokemonapp.unit.services;

import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.errors.ApplicationException;
import com.formation.pokemonapp.repository.PokemonRepository;
import com.formation.pokemonapp.service.impl.PokemonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DataJpaTest
@DisplayName("Pokemon service should")
public class PokemonServiceTest {
    private PokemonServiceImpl pokemonService;
    @Mock
    private PokemonRepository pokemonRepository;

    @Captor
    ArgumentCaptor<Pokemon> captor;

    private Pokemon pokemon;

    @BeforeEach
    void setUp() {
        pokemonService = new PokemonServiceImpl(pokemonRepository);
        pokemon = Pokemon.builder()
                .id(1)
                .name("one")
                .baseExp(64)
                .build();
    }

    @Test
    @DisplayName("throw null pointer exception")
    void nullData() {
        assertThatThrownBy(() -> pokemonService.savePokemon(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("save pokemon successfully")
    void goodData() throws ApplicationException {
        pokemonService.savePokemon(pokemon);
        verify(pokemonRepository).save(captor.capture());
        assertThat(captor.getValue().getId()).isEqualTo(1);
        assertThat(captor.getValue().getName()).isEqualTo("one");
        assertThat(captor.getValue().getBaseExp()).isEqualTo(64);
        verifyNoMoreInteractions(pokemonRepository);
    }

}
