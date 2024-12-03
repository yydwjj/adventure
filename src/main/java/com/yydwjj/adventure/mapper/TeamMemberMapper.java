package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.TeamMember;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamMemberMapper {
    @Insert("INSERT INTO team_member(team_id,user_id,permission_level ) " +
            "VALUES (#{teamId},#{userId},1)")
    @Options(useGeneratedKeys = true, keyProperty = "teamMemberId", keyColumn = "team_member_id")
    int addTeamMember(TeamMember teamMember);

    @Select("select team_id from team_member where user_id = #{userid}")
    List<Integer> getUserTeamByUid(int userid);


}
