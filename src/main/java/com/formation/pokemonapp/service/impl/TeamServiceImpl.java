package com.formation.pokemonapp.service.impl;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.input.TeamInput;

import com.formation.pokemonapp.repository.TeamRepository;
import com.formation.pokemonapp.service.PokemonService;
import com.formation.pokemonapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PokemonService pokemonService;

    @Override
    public Set<TeamDTO> getAllTeamDTO() {
        Set<Team> teams= new HashSet<>(teamRepository.findAll());
        Set<TeamDTO> teamsDTO = new HashSet<>();

        for(Team team : teams){
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setId(team.getId());
            teamDTO.setName(team.getName());
            teamDTO.setPokemons(pokemonService.getPokemonsByTeam(team.getId()));
            teamsDTO.add(teamDTO);
        }

        return teamsDTO;
    }

    @Override
    public TeamDTO getTeamDTO(long id) {

        Team team= teamRepository.findById(id);

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setPokemons(pokemonService.getPokemonsByTeam(team.getId()));

        return teamDTO;
    }

    @Override
    public Team createOrUpdate(TeamInput teamInput) {
        Team team = null;
        if (teamInput.getId() != 0) {
            team.setId(teamInput.getId());
        }
        team.setName(teamInput.getName());
        team.setPokemons(pokemonService.findByIds(teamInput.getPokemonsId()));
        teamRepository.save(team);
        return team;
    }

    @Override
    public void delete(TeamInput teamInput) {
        teamRepository.delete(teamRepository.findById(teamInput.getId()));
    }


}
