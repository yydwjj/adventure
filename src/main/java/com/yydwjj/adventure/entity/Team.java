package com.sample;


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


  public long getTeamId() {
    return teamId;
  }

  public void setTeamId(long teamId) {
    this.teamId = teamId;
  }


  public long getCaptainId() {
    return captainId;
  }

  public void setCaptainId(long captainId) {
    this.captainId = captainId;
  }


  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }


  public long getTeamState() {
    return teamState;
  }

  public void setTeamState(long teamState) {
    this.teamState = teamState;
  }


  public long getIsPublic() {
    return isPublic;
  }

  public void setIsPublic(long isPublic) {
    this.isPublic = isPublic;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(java.sql.Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }


  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }


  public String getTeamInfo() {
    return teamInfo;
  }

  public void setTeamInfo(String teamInfo) {
    this.teamInfo = teamInfo;
  }

}
