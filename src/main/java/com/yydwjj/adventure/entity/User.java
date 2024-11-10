package com.yydwjj.adventure.entity;


public class User {

  private long userId;
  private String username;
  private String phoneNumber;
  private String email;
  private long schoolId;
  private String notes;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private long userAvatarId;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(long schoolId) {
    this.schoolId = schoolId;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
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


  public long getUserAvatarId() {
    return userAvatarId;
  }

  public void setUserAvatarId(long userAvatarId) {
    this.userAvatarId = userAvatarId;
  }

}
