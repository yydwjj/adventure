package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.Talk;
import com.yydwjj.adventure.entity.TaskCategorie;
import com.yydwjj.adventure.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface talkMapper {
    @Select("select * from talk where userNameId=#{id} or toNameId=#{id}")
    List<Talk> getAllTalk(int id);
    @Select("select * from user where user_id=#{id}")
    User getUser(int id);

    @Insert("insert into  talk(userNameId,toNameId,userName,ToName,msg,createTime) values (#{userNameId},#{toNameId},#{userName},#{ToName},#{msg},#{createTime})")
    int insertTalk(Talk talk);
    @Select("select * from talk where userNameId=#{id1} and toNameId=#{id2} limit 1")
    User checkUser(int id1, int id2);
}
