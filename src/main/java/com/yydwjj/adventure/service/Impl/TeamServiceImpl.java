package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.entity.TeamMember;
import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.mapper.TeamMapper;
import com.yydwjj.adventure.mapper.TeamMemberMapper;
import com.yydwjj.adventure.mapper.UserMapper;
import com.yydwjj.adventure.model.TeamInfo;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.TeamMemberService;
import com.yydwjj.adventure.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamMapper teamMapper;
    @Autowired
    UserMapper userMapper;

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
     * @return 添加完成的队伍结果
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


    /**
     * 根据id获得队伍基本信息
     * @param teamId 队伍的id
     * @return 队伍基本信息
     */
    @Override
    public Result<Team> getTeam(Long teamId) {
        Team team = teamMapper.getTeamByTeamId(teamId);
        return Result.ok(team);
    }

    public TeamInfo getTeamInfo(long teamId) {
        return teamMapper.getTeamInfoById(teamId);
    }

    @Override
    public List<Map<String, Object>> getLeadTeam(int id) {
        return teamMapper.getMyLeadTeamByUid(id);
    }

    @Override
    public Result getTeamMembers(long userId, Long taskId) {
        return null;
    }

    /**
     * 返回队伍成员信息
     * @param teamMember        队伍成员信息
     * @return 队伍成员信息
     */
    @Override
    public TeamMember addTeamMember(TeamMember teamMember) {
        //队伍id
        long teamId = teamMember.getTeamId();
        //用户id
        long userId = teamMember.getUserId();
        User userById = userMapper.selectById(userId);
        if(userById == null){
            //用户不存在
            return null;
        }
        //判断重复入队
        List<User> teamMembersByTeamId = teamMapper.getTeamMembersByTeamId(teamId);
        for(User user : teamMembersByTeamId){
            if(user.getUserId() == userId){
                //重复了
                return null;
            }
        }
        teamMember.setJobId(1);
        teamMember.setPermissionLevel(1);
        //没有重复 添加
        int result= teamMemberMapper.addTeamMember(teamMember);
        return teamMember;
    }

//    @Override
//    public Result getTeamMembers(long userId, Long taskId) {
//        //获得参与队伍的队伍id
//        teamMemberMapper.getUserJoinedTeamId(userId,taskId);
//        //根据id返回队伍成员信息
//    }

    @Override
    public List<Map<String, Object>> searchTeams(String keyword) {
        List<Long> teamIds = teamMapper.getTeamIdsByKeyword(keyword);
        if (teamIds.isEmpty()) {
            return Collections.emptyList();
        }
        return teamMapper.getTeamsByIds(teamIds);
    }
}