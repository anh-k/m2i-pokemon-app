package com.formation.pokemonapp.entity;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemon_id")
    @NotNull
    private Set<Pokemon> pokemons = new HashSet<>();
}
