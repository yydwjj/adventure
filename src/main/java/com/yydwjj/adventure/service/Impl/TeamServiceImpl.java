package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.mapper.TeamMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamMapper teamMapper;

    @Override
    public List<Map<String, Object>> getTeamList() {
        return teamMapper.selectTeamList();
    }

    @Override
    public Result<Team> add(Team team) {
        teamMapper.addTeam(team);
        int result = (int) team.getTeamId();
        if (result != 0) {
            return Result.ok(team);
        }
        return Result.build(null,506,"add failed");
    }
}