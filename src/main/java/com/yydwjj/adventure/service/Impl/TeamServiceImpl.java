package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.mapper.TeamMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamMapper teamMapper;
    @Override
    public Result<Integer> add(Team team) {
        int result = teamMapper.addTeam(team);
        if (result == 1) {
            return Result.ok(result);
        }
        return Result.build(null,506,"add failed");
    }
}
