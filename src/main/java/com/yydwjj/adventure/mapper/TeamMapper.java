package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.JobPost;
import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.model.TeamInfo;
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

    @Select("select * from team where captain_id = #{captionId} and task_id = #{taskId}")
    List<Team> getTeamsByCaptionId(int captionId,int taskId);

    @Select("select * from team where team_id = #{teamId}")
    Team getTeamByTeamId(Long teamId);

    /**
     * 获取完整的队伍信息
     * @param teamId 队伍ID
     * @return 队伍信息对象
     */
    @Select(
            "SELECT"+
            "    t.team_id, t.captain_id, t.task_id, t.team_state, t.is_public,"+
            "    t.created_at, t.deleted_at, t.team_name, t.team_info,"+
            "    u.username AS captain_name,"+
            "    tk.task_name "+
            "FROM team t "+
            "LEFT JOIN `user` u ON t.captain_id = u.user_id "+
            "LEFT JOIN task tk ON t.task_id = tk.task_id "+
            "WHERE t.team_id = #{teamId} "
    )
    @Results(id = "teamInfoMap", value = {
            @Result(column = "team_id", property = "teamId"),
            @Result(column = "captain_id", property = "captainId"),
            @Result(column = "task_id", property = "taskId"),
            @Result(column = "team_state", property = "teamState"),
            @Result(column = "is_public", property = "isPublic"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "deleted_at", property = "deletedAt"),
            @Result(column = "team_name", property = "teamName"),
            @Result(column = "team_info", property = "teamInfo"),
            @Result(column = "captain_name", property = "captainName"),
            @Result(column = "task_name", property = "taskName"),
            @Result(property = "teamMembers", column = "team_id",
                    many = @Many(select = "getTeamMembersByTeamId")),
            @Result(property = "jobs", column = "team_id",
                    many = @Many(select = "getJobsByTeamId"))
    })
    TeamInfo getTeamInfoById(@Param("teamId") long teamId);

    /**
     * 获取指定队伍的队员信息
     * @param teamId 队伍ID
     * @return 队员信息列表
     */
    @Select({
            "SELECT u.* FROM `user` u "+
            "INNER JOIN team_member tm ON u.user_id = tm.user_id "+
            "WHERE tm.team_id = #{teamId} "
    })
    List<User> getTeamMembersByTeamId(@Param("teamId") long teamId);

    /**
     * 获取指定队伍的岗位信息
     * @param teamId 队伍ID
     * @return 岗位信息列表
     */
    @Select({
            "SELECT * FROM job_post WHERE team_id = #{teamId}"
    })
    List<JobPost> getJobsByTeamId(@Param("teamId") long teamId);
}