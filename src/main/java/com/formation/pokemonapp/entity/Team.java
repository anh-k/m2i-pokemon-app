package com.formation.pokemonapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
@Data
public class Team {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="name", nullable = false)
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_user", referencedColumnName = "id")
//    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "teams", allowSetters = true)
    @JoinTable(name="team_pokemon",
            joinColumns = @JoinColumn(name="id_teams", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_pokemon",referencedColumnName = "id"))
    private Set<Pokemon> pokemons = new HashSet<>();


}
