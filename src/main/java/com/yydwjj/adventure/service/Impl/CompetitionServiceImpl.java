package com.yydwjj.adventure.service.Impl;

import java.util.List;
import java.util.Map;

import com.yydwjj.adventure.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yydwjj.adventure.mapper.CompetitionMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.CompetitionService;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;

    @Override
    public Result getCompetitionList() {
        List<Map<String, Object>> list = competitionMapper.getCompetitionList();
        return Result.ok(list);
    }

    @Override
    public Result getCompetitionInfo(Integer id) {
        Map<String, Object> info = competitionMapper.getCompetitionInfo(id);
        return Result.ok(info);
    }

    @Override
    public Result searchCompetitions(String keyword) {
        List<Map<String, Object>> competitions = competitionMapper.searchCompetitionsByKeyword(keyword);
        return Result.ok(competitions);
    }
}