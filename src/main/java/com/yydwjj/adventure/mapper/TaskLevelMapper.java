package com.yydwjj.adventure.mapper;


import com.yydwjj.adventure.entity.TaskLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskLevelMapper {

    @Select("select * from adventure.task_level")
    List<TaskLevel> getAll();
}
