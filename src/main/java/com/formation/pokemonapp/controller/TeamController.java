package com.formation.pokemonapp.controller;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.errors.ApplicationException;
import com.formation.pokemonapp.input.TeamInput;
import com.formation.pokemonapp.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
@Slf4j
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public Set<TeamDTO> getTeams() {
        return teamService.getAllTeamDTO();
    }

    @GetMapping("/{teamId}")
    public TeamDTO getTeam(@PathVariable("teamId") final String teamId) throws ApplicationException {
        return teamService.getTeamDTO(Long.valueOf(teamId));
    }

    @PostMapping("/createOrUpdate")
    public Team createOrUpdate(@RequestBody final TeamInput teamInput) throws ApplicationException {
        log.info("{} has been saved", teamInput);
        return teamService.createOrUpdate(teamInput);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody final TeamInput teamInput) throws ApplicationException {
        teamService.delete(teamInput);
    }
}
