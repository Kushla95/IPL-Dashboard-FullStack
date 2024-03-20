package com.zkteco.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zkteco.ipldashboard.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    // @Query("select distinct t from Team t where t.teamName =?1")
    Team findByTeamName(String teamName);

}
