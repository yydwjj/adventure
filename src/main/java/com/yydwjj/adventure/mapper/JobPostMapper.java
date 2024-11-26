package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.JobPost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JobPostMapper {

    @Insert("insert into adventure.job_post(adventure.job_post.team_id, adventure.job_post.job_title," +
            " adventure.job_post.job_requirements, adventure.job_post.contact_info) " +
            "value (#{teamId},#{jobTitle},#{jobRequirements},#{contactInfo})")
    int add(JobPost jobPost);

    int batchInsert(@Param("jobs") List<JobPost> jobs);
}
