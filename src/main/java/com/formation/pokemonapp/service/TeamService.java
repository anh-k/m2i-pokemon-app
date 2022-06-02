package com.formation.pokemonapp.service;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
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
    TeamDTO getTeamDTO(long id);

    /**
     * Création ou modification d'une team
     */
    Team saveTeam(@NonNull Team team);

    /**
     * Suppression d'une team
     */
    void delete(long id);

    /**
     * Récupération d'une team grâce à l'id
     */
    Team getTeam(long id);

}
