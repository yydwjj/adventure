package com.yydwjj.adventure.service;

import java.util.List;
import java.util.Map;

public interface TeamService {
    List<Map<String, Object>> getTeamList();

    List<Map<String, Object>> getLevels();

    List<Map<String, Object>> getCategories();
}