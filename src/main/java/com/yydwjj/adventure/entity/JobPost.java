package com.yydwjj.adventure.entity;


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


  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }


  public long getTeamId() {
    return teamId;
  }

  public void setTeamId(long teamId) {
    this.teamId = teamId;
  }


  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }


  public String getJobRequirements() {
    return jobRequirements;
  }

  public void setJobRequirements(String jobRequirements) {
    this.jobRequirements = jobRequirements;
  }


  public String getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(String contactInfo) {
    this.contactInfo = contactInfo;
  }


  public long getIsJobExist() {
    return isJobExist;
  }

  public void setIsJobExist(long isJobExist) {
    this.isJobExist = isJobExist;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }


  public java.sql.Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(java.sql.Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }

}
