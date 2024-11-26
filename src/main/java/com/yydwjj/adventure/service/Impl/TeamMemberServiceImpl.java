package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.TeamMember;
import com.yydwjj.adventure.mapper.TeamMemberMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    @Autowired
    TeamMemberMapper teamMemberMapper;

    @Override
    public Result<Integer> addTeamMember(TeamMember teamMember) {
        int result = teamMemberMapper.addTeamMember(teamMember);
        if (result == 1) {
            return Result.ok(result);
        }
        return Result.build(null,506,"not add  member");
    }
}
