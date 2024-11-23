package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {

    @Insert("INSERT INTO adventure.team (captain_id, task_id,created_at, team_name, team_info) " +
            "VALUES (#{captainId}, #{taskId}, #{createdAt},  #{teamName}, #{teamInfo})")
    int addTeam(Team team);
}
