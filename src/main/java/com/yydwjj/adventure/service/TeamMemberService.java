package com.yydwjj.adventure.service;


import com.yydwjj.adventure.entity.TeamMember;
import com.yydwjj.adventure.result.Result;

public interface TeamMemberService {

    Result<Integer> addTeamMember(TeamMember teamMember);
}
