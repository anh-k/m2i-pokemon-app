package com.formation.pokemonapp.entity;

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

}
