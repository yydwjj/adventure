package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.mapper.TeamMapper;
import com.yydwjj.adventure.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Map<String, Object>> getTeamList() {
        return teamMapper.selectTeamList();
    }

    @Override
    public List<Map<String, Object>> getLevels() {
        return teamMapper.selectAllLevels();
    }

    @Override
    public List<Map<String, Object>> getCategories() {
        return teamMapper.selectAllCategories();
    }
}