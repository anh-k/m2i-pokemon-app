package com.formation.pokemonapp.service;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.input.TeamInput;

import java.util.Set;

public interface TeamService {
    /**
     * Récupération des teams
     */
    Set<TeamDTO> getAllTeamDTO();

    /**
     * Récupération d'une team grâce à l'id
     */
    TeamDTO getTeamDTO(long id);

    /**
     * Création ou modification d'une team
     */
    Team createOrUpdate(final TeamInput teamInput);

    /**
     * Suppression d'une team
     */
    void delete(final TeamInput teamInput);

}
