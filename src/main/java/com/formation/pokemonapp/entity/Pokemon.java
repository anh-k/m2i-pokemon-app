package com.formation.pokemonapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.formation.pokemonapp.dto.TeamDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pokemon")
@Data
public class Pokemon {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "baseExp")
    private int baseExp;

    @ManyToMany(mappedBy = "pokemons")
    private Set<Team> teams = new HashSet<>();
}
