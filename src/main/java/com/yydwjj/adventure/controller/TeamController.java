package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.TeamService;
import com.yydwjj.adventure.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "team")
public class TeamController {

    @Autowired
    TeamService teamService;
    @Autowired
    JwtHelper jwtHelper;

    @PostMapping(value = "create")
    public Result<Team> create(@RequestHeader String token, @RequestBody Team team) {
        Long userId = jwtHelper.getUserId(token);
        team.setCaptainId(userId);
        team.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return teamService.add(team);
    }
}
