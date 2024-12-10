package com.yydwjj.adventure.mapper;

import java.util.List;
import java.util.Map;

import com.yydwjj.adventure.entity.Task;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CompetitionMapper {

    @Select("""
        SELECT
            t.task_id,
            t.task_name,
            t.task_info,
            t.registration_start,
            t.registration_end,
            t.task_start,
            t.task_end,
            l.level_name,
            c.category_name
        FROM task t
        LEFT JOIN task_level l ON t.task_level_id = l.task_level_id
        LEFT JOIN task_categorie c ON t.task_category_id = c.task_category_id
        WHERE t.is_exist = 1
        ORDER BY t.created_at DESC
            """)
    @Results({
            @Result(column = "task_id", property = "taskId"),
            @Result(column = "task_name", property = "taskName"),
            @Result(column = "task_info", property = "taskInfo"),
            @Result(column = "registration_start", property = "registrationStart"),
            @Result(column = "registration_end", property = "registrationEnd"),
            @Result(column = "task_start", property = "taskStart"),
            @Result(column = "task_end", property = "taskEnd"),
            @Result(column = "level_name", property = "levelName"),
            @Result(column = "category_name", property = "categoryName")
    })
    List<Map<String, Object>> getCompetitionList();

    @Select("""
        SELECT 
            t.task_id,
            t.task_name,
            t.task_info,
            t.registration_start,
            t.registration_end,
            t.task_start,
            t.task_end,
            l.level_name,
            c.category_name
        FROM task t
        LEFT JOIN task_level l ON t.task_level_id = l.task_level_id
        LEFT JOIN task_categorie c ON t.task_category_id = c.task_category_id
        WHERE t.task_id = #{id} AND t.is_exist = 1
    """)
    @Results({
            @Result(column = "task_id", property = "taskId"),
            @Result(column = "task_name", property = "taskName"),
            @Result(column = "task_info", property = "taskInfo"),
            @Result(column = "registration_start", property = "registrationStart"),
            @Result(column = "registration_end", property = "registrationEnd"),
            @Result(column = "task_start", property = "taskStart"),
            @Result(column = "task_end", property = "taskEnd"),
            @Result(column = "level_name", property = "levelName"),
            @Result(column = "category_name", property = "categoryName")
    })
    Map<String, Object> getCompetitionInfo(Integer id);

    @Select("SELECT " +
            "t.task_id AS taskId, " +
            "t.task_name AS taskName, " +
            "tl.level_name AS levelName, " +
            "tc.category_name AS categoryName, " +
            "t.registration_start AS registrationStart, " +
            "t.registration_end AS registrationEnd, " +
            "t.task_start AS taskStart, " +
            "t.task_end AS taskEnd, " +
            "t.task_info AS taskInfo " +
            "FROM task t " +
            "LEFT JOIN task_level tl ON t.task_level_id = tl.task_level_id " +
            "LEFT JOIN task_categorie tc ON t.task_category_id = tc.task_category_id " +
            "WHERE (t.task_name LIKE CONCAT('%', #{keyword}, '%') " +
            "OR tl.level_name LIKE CONCAT('%', #{keyword}, '%') " +
            "OR tc.category_name LIKE CONCAT('%', #{keyword}, '%') " +
            "OR t.task_info LIKE CONCAT('%', #{keyword}, '%')) " +
            "AND t.is_exist = 1 " +
            "ORDER BY t.created_at DESC")
    List<Map<String, Object>> searchCompetitionsByKeyword(@Param("keyword") String keyword);
}