package com.yydwjj.adventure.model;

import com.yydwjj.adventure.entity.JobPost;
import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class TeamInfo {

    private long teamId;
    private long captainId;
    private long taskId;
    private long teamState;
    private long isPublic;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp deletedAt;
    private String teamName;
    private String teamInfo;

    // 队长名字
    private String captainName;
    //队员信息
    private List<User> teamMembers;
    //岗位信息
    private List<JobPost> jobs;
    //任务名字
    private String TaskName;
}
