package com.formation.pokemonapp.controller;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.input.TeamInput;
import com.formation.pokemonapp.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
@Slf4j
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/allTeams")
    public Set<TeamDTO> getTeams() {
        return teamService.getAllTeamDTO();
    }

    @GetMapping("/{teamId}")
    public TeamDTO getTeam(@PathVariable("teamId") final long teamId) {
        return teamService.getTeamDTO(Long.valueOf(teamId));
    }

    @PostMapping("/createOrUpdate")
    public Team createOrUpdate(@RequestBody final TeamInput teamInput) {
        log.info("{} has been saved", teamInput);
        return teamService.createOrUpdate(teamInput);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody final TeamInput teamInput) {
        teamService.delete(teamInput);
    }
}
