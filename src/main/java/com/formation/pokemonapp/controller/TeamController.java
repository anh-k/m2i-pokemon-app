package com.formation.pokemonapp.controller;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.input.TeamInput;
import com.formation.pokemonapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/allTeams")
    public Set<TeamDTO> getTeams() {
        return teamService.getAllTeamDTO();
    }

    @GetMapping("/{idTeam}")
    public TeamDTO getTeam(@PathVariable("idTeam") final long idTeam) {
        return teamService.getTeamDTO(Long.valueOf(idTeam));
    }

    @PostMapping("/createOrUpdate")
    public Team createOrUpdate(@RequestBody final TeamInput teamInput) {
        return teamService.createOrUpdate(teamInput);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody final TeamInput teamInput) {
        teamService.delete(teamInput);
    }
}
