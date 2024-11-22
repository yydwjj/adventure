package com.yydwjj.adventure.model;

import lombok.Data;

@Data
public class TaskInfo {
    private long taskId;
    private String taskName;
    private long publisherId;
    private long taskLevelId;
    private long taskCategoryId;
    private java.sql.Timestamp registrationStart;
    private java.sql.Timestamp registrationEnd;
    private java.sql.Timestamp taskStart;
    private java.sql.Timestamp taskEnd;
    private long participantLimit;
    private String location;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
    private java.sql.Timestamp deletedAt;
    private String taskInfo;
    private int isExist;
    //级别表中的数据
    private String levelName;
    //用户表中的数据
    private String username;
    //任务分类表中的数据
    private String categoryName;
}
