package com.yydwjj.adventure.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}