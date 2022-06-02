package com.formation.pokemonapp.service.impl;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Pokemon;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.errors.ApplicationException;
import com.formation.pokemonapp.input.PokemonInput;
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
    protected PokemonService pokemonService;

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
        if(null == teamRepository.findById(id)){
            throw new ApplicationException("Nous ne parvenons pas à récupérer l'équipe'.");
        }
        Team team = teamRepository.findById(id);

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setPokemons(pokemonService.convertPokemonToDTO(team.getPokemons()));
        return teamDTO;
    }

    @Override
    public Team createOrUpdate(TeamInput teamInput) throws ApplicationException {
        Team team = new Team();
        if (teamInput.getId() != 0) {
            if(teamRepository.findById(teamInput.getId()) == null){
                throw new ApplicationException("Nous ne parvenons pas à récupérer l'équipe "
                        + teamInput.getName()
                        + ".");
            }
            team.setId(teamInput.getId());
        }
        team.setName(teamInput.getName());
        team.setPokemons(this.createPokemons(teamInput.getPokemons()));
        return teamRepository.save(team) ;
    }

    public Set<Pokemon> createPokemons(Set<PokemonInput> pokemonsInput) throws ApplicationException {
        Set<Pokemon> pokemons = new HashSet<>();
        for (PokemonInput pokemonInput : pokemonsInput) {
            Pokemon pokemon = pokemonService.createOrUpdate(pokemonInput);
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    @Override
    public void delete(TeamInput teamInput) throws ApplicationException{
        Team team = null;
        if(0 != teamInput.getId() )
            team =teamRepository.findById(teamInput.getId());
            if(null == team ){
            throw new ApplicationException("Nous ne parvenons pas à supprimer l'équipe "
                    + teamInput.getName()
                    + ".");
        }
        teamRepository.delete(teamRepository.findById(teamInput.getId()));
    }

    @Override
    public Team getTeam(long id) {
        return teamRepository.findById(id);
    }


}
