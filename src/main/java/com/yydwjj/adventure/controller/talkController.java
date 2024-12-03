package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.Talk;
import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.mapper.talkMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.Impl.TalkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("talk")
public class talkController {
    @Autowired
    talkMapper talkMapper;

    @Autowired
    TalkServiceImpl talkserive;
    @GetMapping(value ="getAllTalk/{id}")
    public List<Talk> getAllTalk(@PathVariable int id){
        return  talkMapper.getAllTalk(id);
    }

    @GetMapping(value ="insertTalk/{userNameId}/{toNameId}")
    public int insertTalk(@PathVariable int userNameId,@PathVariable int toNameId){
        if(talkMapper.checkUser(userNameId,toNameId)==null)
            return talkserive.insertTalk(userNameId,toNameId);
        else
            return 0;
    }
    @GetMapping(value ="insertTalk/{userNameId}/{toNameId}/{msg}/{createTime}")
    public int insertTalk(@PathVariable int userNameId,@PathVariable int toNameId,@PathVariable String msg,@PathVariable String createTime){
        Talk talk=new Talk();
        talk.setUserNameId(userNameId);
        talk.setToNameId(toNameId);
        User user=new User();
        user=talkMapper.getUser(userNameId);
        User toUser=new User();
        toUser=talkMapper.getUser(toNameId);
        talk.setUserName(user.getUsername());
        talk.setToName(toUser.getUsername());
        talk.setMsg(msg);
        talk.setCreateTime(createTime);
        return talkMapper.insertTalk(talk);
    }

}
