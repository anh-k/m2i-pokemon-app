package com.formation.pokemonapp.service.impl;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.errors.ApplicationException;
import com.formation.pokemonapp.repository.TeamRepository;
import com.formation.pokemonapp.service.PokemonService;
import com.formation.pokemonapp.service.TeamService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final PokemonService pokemonService;

    @Override
    public Set<TeamDTO> getAllTeamDTO() {
        Set<Team> teams = new HashSet<>(teamRepository.findAll());
        Set<TeamDTO> teamsDTO = new HashSet<>();

        for (Team team : teams) {
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setId(team.getId());
            teamDTO.setName(team.getName());
            teamDTO.setPokemons(pokemonService.convertPokemonToDTO(team.getPokemons()));
            teamsDTO.add(teamDTO);
        }

        return teamsDTO;
    }

    @Override
    public TeamDTO getTeamDTO(long id) throws ApplicationException {
        Team team = teamRepository.findById(id);

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setPokemons(pokemonService.convertPokemonToDTO(team.getPokemons()));
        return teamDTO;
    }

    @Override
    public Team saveTeam(@NonNull Team team) throws ApplicationException {
        return teamRepository.save(team);
    }

    @Override
    public void delete(long id) throws ApplicationException {
        teamRepository.delete(teamRepository.findById(id));
    }

    @Override
    public Team getTeam(long id) {
        return teamRepository.findById(id);
    }


}
