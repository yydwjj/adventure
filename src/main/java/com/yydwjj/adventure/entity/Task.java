package com.sample;


public class Task {

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


  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }


  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }


  public long getPublisherId() {
    return publisherId;
  }

  public void setPublisherId(long publisherId) {
    this.publisherId = publisherId;
  }


  public long getTaskLevelId() {
    return taskLevelId;
  }

  public void setTaskLevelId(long taskLevelId) {
    this.taskLevelId = taskLevelId;
  }


  public long getTaskCategoryId() {
    return taskCategoryId;
  }

  public void setTaskCategoryId(long taskCategoryId) {
    this.taskCategoryId = taskCategoryId;
  }


  public java.sql.Timestamp getRegistrationStart() {
    return registrationStart;
  }

  public void setRegistrationStart(java.sql.Timestamp registrationStart) {
    this.registrationStart = registrationStart;
  }


  public java.sql.Timestamp getRegistrationEnd() {
    return registrationEnd;
  }

  public void setRegistrationEnd(java.sql.Timestamp registrationEnd) {
    this.registrationEnd = registrationEnd;
  }


  public java.sql.Timestamp getTaskStart() {
    return taskStart;
  }

  public void setTaskStart(java.sql.Timestamp taskStart) {
    this.taskStart = taskStart;
  }


  public java.sql.Timestamp getTaskEnd() {
    return taskEnd;
  }

  public void setTaskEnd(java.sql.Timestamp taskEnd) {
    this.taskEnd = taskEnd;
  }


  public long getParticipantLimit() {
    return participantLimit;
  }

  public void setParticipantLimit(long participantLimit) {
    this.participantLimit = participantLimit;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
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


  public String getTaskInfo() {
    return taskInfo;
  }

  public void setTaskInfo(String taskInfo) {
    this.taskInfo = taskInfo;
  }

}
