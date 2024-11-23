package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.result.Result;

public interface TeamService {

    /**
     * 创建队伍
     * @param team 队伍信息
     * @return  创建成功data是1，失败data是0
     */
    Result<Integer> add(Team team);
}
