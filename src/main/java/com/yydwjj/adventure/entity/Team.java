package com.yydwjj.adventure.entity;

import lombok.Data;

@Data
public class Team {

  private long teamId;
  private long captainId;
  private long taskId;
  private long teamState;
  private long isPublic;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp deletedAt;
  private String teamName;
  private String teamInfo;

}
