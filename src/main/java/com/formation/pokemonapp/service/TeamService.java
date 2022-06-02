package com.formation.pokemonapp.service;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.errors.ApplicationException;
import lombok.NonNull;

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
    Team saveTeam(@NonNull Team team) throws ApplicationException;

    /**
     * Suppression d'une team
     */
    void delete(long id) throws ApplicationException;

    /**
     * Récupération d'une team grâce à l'id
     */
    Team getTeam(long id);

}
