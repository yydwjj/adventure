package com.yydwjj.adventure.entity;


import lombok.Data;
@Data
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
  private String userPwd;


}
