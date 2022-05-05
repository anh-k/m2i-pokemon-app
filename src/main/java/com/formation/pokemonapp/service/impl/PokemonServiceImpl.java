package com.formation.pokemonapp.service.impl;

import com.formation.pokemonapp.dto.PokemonDTO;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.input.PokemonInput;
import com.formation.pokemonapp.repository.PokemonRepository;
import com.formation.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

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
    public Pokemon createOrUpdate(PokemonInput pokemonInput) {
        Pokemon pokemon = new Pokemon();
        if (pokemonInput.getId() != 0) {
            pokemon.setId(pokemonInput.getId());
        }
        pokemon.setName(pokemonInput.getName());
        pokemon.setBaseExp(pokemonInput.getBaseExp());
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
