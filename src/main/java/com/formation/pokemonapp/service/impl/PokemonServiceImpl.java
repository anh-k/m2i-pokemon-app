package com.formation.pokemonapp.service.impl;

import com.formation.pokemonapp.dto.PokemonDTO;
import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.repository.PokemonRepository;
import com.formation.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public Set<PokemonDTO> getPokemonsByTeam(long idTeam ) {
        Set<Pokemon> pokemons =pokemonRepository.getPokemonsByTeamId(idTeam);
        Set<PokemonDTO> pokemonsDTO = new HashSet<>();

        for(Pokemon pokemon : pokemons){
            PokemonDTO pokemonDTO = new PokemonDTO();
            pokemonDTO.setId(pokemon.getId());
            pokemonDTO.setName(pokemon.getName());
            pokemonDTO.setBaseExp(pokemon.getBaseExp());
            pokemonsDTO.add(pokemonDTO);
        }

        return pokemonsDTO;
    }

    @Override
    public Set<Pokemon> findByIds(Set<Long> pokemonsId) {
        return pokemonRepository.getPokemonsByids(pokemonsId);
    }


}