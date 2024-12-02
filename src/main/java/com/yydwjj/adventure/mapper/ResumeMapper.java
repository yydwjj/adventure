package com.yydwjj.adventure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    //寻找某个用户未被删除的所有简历
    @Select("select * from adventure.resume where adventure.resume.user_id=#{userId} "+
            " and deleted_at IS NULL order by updated_at desc ")
    List<Resume> findAllResumes(Long userId);

    //创建简历
    @Insert("INSERT INTO adventure.resume (adventure.resume.user_id, "+
            "adventure.resume.resume_name, adventure.resume.name, "+
            "adventure.resume.phone_number, adventure.resume.email,"+
            " adventure.resume.school, adventure.resume.major,"+
            " adventure.resume.desired_position, adventure.resume.personal_strengths, "+
            "adventure.resume.previous_experience, adventure.resume.created_at, "+
            "adventure.resume.updated_at) " +
            "VALUES (#{userId},#{resumeName},#{name},#{phoneNumber},#{email},#{school},"+
            "#{major},#{desiredPosition},#{personalStrengths},#{previousExperience},#{createdAt},#{updatedAt});")
    int create(Resume resume);

    //编辑更新简历
    @Update("UPDATE adventure.resume " +
            "SET resume_name = #{resumeName}, " +
            "    name = #{name}, " +
            "    phone_number = #{phoneNumber}, " +
            "    email = #{email}, " +
            "    school = #{school}, " +
            "    major = #{major}, " +
            "    desired_position = #{desiredPosition}, " +
            "    personal_strengths = #{personalStrengths}, " +
            "    previous_experience = #{previousExperience}, " +
            "    updated_at = #{updatedAt} " +
            "WHERE resume_id = #{resumeId}")
    int edit(Resume resume);

    //假删除简历
    @Update("UPDATE adventure.resume " +
            "SET deleted_at = #{deletedAt} " +
            "WHERE resume_id = #{resumeId}")
    int delete(Resume resume);

    @Select("select * from adventure.resume where adventure.resume.user_id=#{userId} order by resume_id desc limit 1")
    Resume findLastResumes(Long userId);

    @Select("select * from adventure.resume where adventure.resume.user_id=#{userId} order by resume_id desc limit 1")
    Resume showResumes(Long userId);

    @Select("select * from adventure.resume where adventure.resume.resume_id=#{resumeId} limit 1")
    Resume showResumesById(int resumeId);

}