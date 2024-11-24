package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.result.Result;
import java.util.List;
import java.util.Map;

public interface TeamService {
    List<Map<String, Object>> getTeamList();

    /**
     * 创建队伍
     * @param team 队伍信息
     * @return  返回的int 队伍id
     */
    Result<Team> add(Team team);

    /**
     * 获取队伍详细信息
     * @param teamId 队伍的id
     * @return  包含队长和成员等的详细信息
     */
    Result<Team> getTeamInfo(Long teamId);

    Result<List<Team>> getTeamsByCaptionId(int captionId);
}
