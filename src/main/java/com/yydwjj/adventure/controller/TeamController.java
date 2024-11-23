package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/list")
    public List<Map<String, Object>> getTeamList() {
        return teamService.getTeamList();
    }

    @GetMapping("/levels")
    public List<Map<String, Object>> getLevels() {
        return teamService.getLevels();
    }

    @GetMapping("/categories")
    public List<Map<String, Object>> getCategories() {
        return teamService.getCategories();
    }
}