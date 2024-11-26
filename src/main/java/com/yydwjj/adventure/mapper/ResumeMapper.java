package com.yydwjj.adventure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
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

    @Select("select * from adventure.resume where adventure.resume.user_id=#userId order by resume_id desc ")
    List<Resume> findAllResumes(Long userId);

    @Insert("INSERT INTO adventure.resume (adventure.resume.user_id, "+
            "adventure.resume.resume_name, adventure.resume.name, "+
            "adventure.resume.phone_number, adventure.resume.email,"+
            " adventure.resume.school, adventure.resume.major,"+
            " adventure.resume.desired_position, adventure.resume.personal_strengths, "+
            "adventure.resume.previous_experience, adventure.resume.created_at, "+
            "adventure.resume.updated_at) " +
            "VALUES (#{userId},#{resumeName},#{name},#{phoneNumber},#{email},#{school},"+
            "#{major},#{desiredPosition},#{personalStrengths},#{previousExperience},#{createdAt},#{updatedAt});")
    int save(Resume resume);

    @Select("select * from adventure.resume where adventure.resume.user_id=#{userId} order by resume_id desc limit 1")
    Resume findLastResumes(Long userId);

    @Select("select * from adventure.resume where adventure.resume.user_id=#{userId} order by resume_id desc limit 1")
    Resume showResumes(Long userId);

    @Select("select * from adventure.resume where adventure.resume.resume_id=#{resumeId} limit 1")
    Resume showResumesById(int resumeId);
}