package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.Team;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface TeamMapper {

    @Insert("INSERT INTO adventure.team (captain_id, task_id, created_at, team_name, team_info) " +
            "VALUES (#{captainId}, #{taskId}, #{createdAt}, #{teamName}, #{teamInfo})")
    @Options(useGeneratedKeys = true, keyProperty = "teamId")
    void addTeam(Team team);

    @Select("SELECT " +
            "CONVERT(t.team_id, UNSIGNED) AS teamId, " +
            "t.team_name AS teamName, " +
            "t.team_info AS teamInfo, " +
            "task.task_name AS taskName, " +
            "jp.job_title AS jobTitle, " +
            "u.username AS captainName, " +
            "tl.level_name AS levelName, " +
            "tc.category_name AS categoryName " +
            "FROM team t " +
            "LEFT JOIN task ON t.task_id = task.task_id " +
            "LEFT JOIN job_post jp ON t.team_id = jp.team_id " +
            "LEFT JOIN user u ON t.captain_id = u.user_id " +
            "LEFT JOIN task_level tl ON task.task_level_id = tl.task_level_id " +
            "LEFT JOIN task_categorie tc ON task.task_category_id = tc.task_category_id " +
            "WHERE t.is_public = 1 " +
            "AND t.team_state = 1 " +
            "AND t.deleted_at IS NULL " +
            "ORDER BY t.created_at DESC")
    List<Map<String, Object>> selectTeamList();

    @Select("select * from team where captain_id = #{captionId}")
    List<Team> getTeamsByCaptionId(int captionId);
}