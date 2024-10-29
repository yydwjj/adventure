package com.sample;


public class TeamMember {

  private long teamMemberId;
  private long jobId;
  private long userId;
  private long permissionLevel;
  private long isInTeam;


  public long getTeamMemberId() {
    return teamMemberId;
  }

  public void setTeamMemberId(long teamMemberId) {
    this.teamMemberId = teamMemberId;
  }


  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getPermissionLevel() {
    return permissionLevel;
  }

  public void setPermissionLevel(long permissionLevel) {
    this.permissionLevel = permissionLevel;
  }


  public long getIsInTeam() {
    return isInTeam;
  }

  public void setIsInTeam(long isInTeam) {
    this.isInTeam = isInTeam;
  }

}
