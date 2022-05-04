package com.formation.pokemonapp.controller;

import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.input.PokemonInput;
import com.formation.pokemonapp.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @PostMapping("/createOrUpdate")
    public Pokemon createOrUpdate(@RequestBody final PokemonInput pokemonInput) {
        return pokemonService.createOrUpdate(pokemonInput);
    }
}
