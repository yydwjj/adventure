package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.result.Result;

public interface TeamService {

    /**
     * 创建队伍
     * @param team 队伍信息
     * @return  返回的int 队伍id
     */
    Result<Team> add(Team team);
}
