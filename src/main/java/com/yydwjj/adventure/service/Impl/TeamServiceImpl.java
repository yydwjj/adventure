package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.entity.TeamMember;
import com.yydwjj.adventure.mapper.TeamMapper;
import com.yydwjj.adventure.mapper.TeamMemberMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.TeamMemberService;
import com.yydwjj.adventure.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    TeamMemberService teamMemberService;
    @Autowired
    private TeamMemberMapper teamMemberMapper;

    @Override
    public Result<List<Team>> getTeamsByCaptionId(int captionId) {

        return Result.build(null,405,"this method is creating");
    }

    @Override
    public List<Map<String, Object>> getTeamList() {
        return teamMapper.selectTeamList();
    }

    /**
     * 判断是否重复参赛，
     * 创建队伍的同时，将队长添加到队伍成员表中
     * @param team 队伍信息
     * @return
     */
    @Override
    public Result<Team> add(Team team) {
        //判断是否重复参加比赛
        List<Team> teamsByCaptionId = teamMapper.getTeamsByCaptionId((int) team.getCaptainId(),(int) team.getTaskId());
        if(!teamsByCaptionId.isEmpty()){
            return Result.build(null,506,"Duplicate participation is not permitted");
        }
        //创建队伍
        teamMapper.addTeam(team);
        int result = (int) team.getTeamId();
        if (result != 0) {

            //创建队长的队伍成员信息
            TeamMember teamMember = new TeamMember();
            teamMember.setUserId(team.getCaptainId());
            teamMember.setTeamId(team.getTeamId());
            teamMemberMapper.addTeamMember(teamMember);

            return Result.ok(team);
        }

        return Result.build(null,506,"add failed");
    }

    @Override
    public Result<Team> getTeamInfo(Long teamId) {
        return null;
    }
}