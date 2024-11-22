package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolMapper {
    @Select("select * from adventure.school")
    List<School> getAllSchool();
}
