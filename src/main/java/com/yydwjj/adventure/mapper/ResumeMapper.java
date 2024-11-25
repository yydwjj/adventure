package com.yydwjj.adventure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yydwjj.adventure.entity.Resume;

@Mapper
public interface ResumeMapper {
    @Select("""
        SELECT 
            resume_id,
            name,
            major,
            school,
            desired_position,
            personal_strengths
        FROM resume
        WHERE deleted_at IS NULL
        ORDER BY created_at DESC
    """)
    List<Resume> getResumeList();
}