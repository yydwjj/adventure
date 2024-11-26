package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.Talk;
import com.yydwjj.adventure.entity.TaskCategorie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface talkMapper {
    @Select("select * from talk where userNameId=#{id} or toNameId=#{id}")
    List<Talk> getAllTalk(int id);
}
