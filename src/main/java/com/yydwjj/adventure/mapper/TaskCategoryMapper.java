package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.TaskCategorie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskCategoryMapper {
    @Select("select * from adventure.task_categorie")
    List<TaskCategorie> getAll();
}
