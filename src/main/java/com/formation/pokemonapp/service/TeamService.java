package com.formation.pokemonapp.service;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.errors.ApplicationException;
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
    TeamDTO getTeamDTO(long id) throws ApplicationException;

    /**
     * Création ou modification d'une team
     */
    Team createOrUpdate(final TeamInput teamInput) throws ApplicationException;

    /**
     * Suppression d'une team
     */
    void delete(final TeamInput teamInput) throws ApplicationException;

    /**
     * Récupération d'une team grâce à l'id
     */
    Team getTeam(long id);

}
