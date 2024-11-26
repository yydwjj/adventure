package com.yydwjj.adventure.entity;

import lombok.Data;

@Data
public class TeamMember {

  private long teamMemberId;
  private long jobId;
  private long userId;
  private long teamId;
  private long permissionLevel;
  private long isInTeam;

}
