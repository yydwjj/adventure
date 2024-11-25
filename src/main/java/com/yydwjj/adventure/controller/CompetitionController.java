package com.yydwjj.adventure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.CompetitionService;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping("/list")
    public Result getCompetitionList() {
        return competitionService.getCompetitionList();
    }

    @GetMapping("/info/{id}")
    public Result getCompetitionInfo(@PathVariable Integer id) {
        return competitionService.getCompetitionInfo(id);
    }
}