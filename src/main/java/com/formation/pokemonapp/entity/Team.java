package com.formation.pokemonapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_user", referencedColumnName = "id")
//    private User user;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @NotNull
    @JsonIgnoreProperties(value = {"team"}, allowSetters = true)
    private Set<Pokemon> pokemons = new HashSet<>();
}
