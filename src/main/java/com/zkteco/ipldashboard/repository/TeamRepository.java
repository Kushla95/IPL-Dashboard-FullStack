package com.zkteco.ipldashboard.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zkteco.ipldashboard.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);

}
