package com.formation.pokemonapp.entity;

import lombok.Data;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "pokemons")
    private Set<Pokemon> pokemons;


}
