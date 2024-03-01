package com.zkteco.ipldashboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.ipldashboard.model.Team;
import com.zkteco.ipldashboard.repository.MatchRepository;
import com.zkteco.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team")
    public Iterable<Team> getAllItem() {
        return this.teamRepository.findAll();
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        // System.out.println("Searching for team with name: " + teamName);

        Team team = this.teamRepository.findByTeamName(teamName);
        // Pageable pageable = PageRequest.of(0, 4);
        team.setMatches(this.matchRepository.findLatestMatchesbyTeam(teamName, 4));
        return team;
    }

    @PostMapping("/teams")
    public void saveTeams(@RequestBody List<Team> teams) {
        this.teamRepository.saveAll(teams);
    }

}
