package com.formation.pokemonapp.repository;

import com.formation.pokemonapp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAll();

    Team findById(long id);

    <S extends Team> List<S> saveAll(Iterable<S> entities);

}
