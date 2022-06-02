package com.formation.pokemonapp.controller;

import com.formation.pokemonapp.dto.PokemonDTO;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.errors.ApplicationException;
import com.formation.pokemonapp.input.PokemonInput;
import com.formation.pokemonapp.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
@Slf4j
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/{pokemonId}")
    public PokemonDTO getPokemon(@PathVariable("pokemonId") final String pokemonId) throws ApplicationException {

                  return pokemonService.getPokemonDTO(Long.valueOf(pokemonId));

    }

    @PostMapping("/createOrUpdate")
    public Pokemon createOrUpdate(@RequestBody final PokemonInput pokemonInput) throws ApplicationException {

            log.info("{} has been saved", pokemonInput);
            return pokemonService.createOrUpdate(pokemonInput);

    }
}
