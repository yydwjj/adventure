package com.yydwjj.adventure.entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobPost {

  private long jobId;
  private long teamId;
  private String jobTitle;
  private String jobRequirements;
  private String contactInfo;
  private long isJobExist;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;


}
