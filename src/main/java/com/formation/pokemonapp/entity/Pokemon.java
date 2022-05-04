package com.formation.pokemonapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pokemon")
@Data
@NoArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "baseExp")
    private int baseExp;

    @ManyToOne
    @JoinColumn(name = "id_team", referencedColumnName = "id")
    @NotNull
    @JsonIgnoreProperties(value = "pokemons", allowSetters = true)
    private Team team;
}
