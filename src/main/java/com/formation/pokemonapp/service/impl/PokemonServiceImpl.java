package com.formation.pokemonapp.service.impl;

import com.formation.pokemonapp.dto.PokemonDTO;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.repository.PokemonRepository;
import com.formation.pokemonapp.service.PokemonService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {
    private final PokemonRepository pokemonRepository;

    @Override
    public Set<Pokemon> findByIds(Set<Long> pokemonsId) {
        return pokemonRepository.getAllByPokemonsId(pokemonsId);
    }

    @Override
    public Set<PokemonDTO> convertPokemonToDTO(Set<Pokemon> pokemons) {
        Set<PokemonDTO> pokemonsDTO = new HashSet<>();
        for (Pokemon pokemon : pokemons) {
            PokemonDTO pokemonDTO = new PokemonDTO();
            pokemonDTO.setId(pokemon.getId());
            pokemonDTO.setName(pokemon.getName());
            pokemonDTO.setBaseExp(pokemon.getBaseExp());
            pokemonsDTO.add(pokemonDTO);
        }
        return pokemonsDTO;
    }

    @Override
    public Pokemon savePokemon(@NonNull Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> findById(Long pokemonId) {
        return pokemonRepository.findById(pokemonId);
    }

    @Override
    public PokemonDTO getPokemonDTO(long id) {
        Pokemon pokemon = pokemonRepository.findById(id);

        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setBaseExp(pokemon.getBaseExp());
        return pokemonDTO;
    }

}
