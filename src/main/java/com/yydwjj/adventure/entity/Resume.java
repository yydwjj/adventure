package com.sample;


public class Resume {

  private long resumeId;
  private long userId;
  private String resumeName;
  private String name;
  private String phoneNumber;
  private String email;
  private String school;
  private String major;
  private String desiredPosition;
  private String personalStrengths;
  private String previousExperience;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;


  public long getResumeId() {
    return resumeId;
  }

  public void setResumeId(long resumeId) {
    this.resumeId = resumeId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getResumeName() {
    return resumeName;
  }

  public void setResumeName(String resumeName) {
    this.resumeName = resumeName;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }


  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }


  public String getDesiredPosition() {
    return desiredPosition;
  }

  public void setDesiredPosition(String desiredPosition) {
    this.desiredPosition = desiredPosition;
  }


  public String getPersonalStrengths() {
    return personalStrengths;
  }

  public void setPersonalStrengths(String personalStrengths) {
    this.personalStrengths = personalStrengths;
  }


  public String getPreviousExperience() {
    return previousExperience;
  }

  public void setPreviousExperience(String previousExperience) {
    this.previousExperience = previousExperience;
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
