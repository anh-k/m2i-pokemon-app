package com.formation.pokemonapp.controller;

import com.formation.pokemonapp.dto.TeamDTO;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.errors.ApplicationException;
import com.formation.pokemonapp.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
@Slf4j
public class TeamController {

    private final TeamService teamService;

    @GetMapping()
    public Set<TeamDTO> getTeams() {
        return teamService.getAllTeamDTO();
    }

    @GetMapping("/{id}")
    public TeamDTO getTeam(@PathVariable("id") final String id) throws ApplicationException {
        log.info("Get team with id {}", id);
        return teamService.getTeamDTO(Long.valueOf(id));
    }

    @PostMapping("/createOrUpdate")
    public Team createOrUpdate(@Valid @RequestBody TeamDTO teamDTO) throws ApplicationException {
        log.info("{} has been saved", teamDTO);
        Team team = teamDTO.convertToEntity();
        return teamService.saveTeam(team);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) throws ApplicationException {
        log.info("Delete team with id {}", id);
        teamService.delete(id);
    }
}
