package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.model.TeamInfo;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.TeamService;
import com.yydwjj.adventure.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/list")
    public List<Map<String, Object>> getTeamList() {
        return teamService.getTeamList();
    }

    /**
     * 根据teamId获得基础的team信息
     * @param teamId    teamId
     * @return 队伍的基本信息
     */
//    @GetMapping("/info/{teamId}")
//    public Result<Team> getTeam(@PathVariable Long teamId) {
//        return teamService.getTeam(teamId);
//    }

    @GetMapping("/info/{teamId}")
    public Result<TeamInfo> getTeamInfo(@PathVariable Long teamId) {
        return Result.ok(teamService.getTeamInfo(teamId));
    }

    /**
     * 我管理的小队
     */
    @GetMapping("/lead")
    public List<Map<String, Object>> getLeadTeam(@RequestHeader String token) {
        Long userId = jwtHelper.getUserId(token);
        return teamService.getLeadTeam(Math.toIntExact(userId));
    }

    @GetMapping("/search")
    public List<Map<String, Object>> searchTeams(@RequestParam String keyword) {
        return teamService.searchTeams(keyword);
    }
}
