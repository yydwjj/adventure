package com.yydwjj.adventure.service;

import com.yydwjj.adventure.result.Result;

public interface CompetitionService {
    Result getCompetitionList();
    Result getCompetitionInfo(Integer id);
}