package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.Talk;
import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.service.talkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yydwjj.adventure.mapper.talkMapper;

import java.util.List;

@Service
public class TalkServiceImpl implements talkService {
    @Autowired
    talkMapper talkMapper;
    public int insertTalk(int userNameId,int toNameId){
        User user=talkMapper.getUser(userNameId);
        User toUser=talkMapper.getUser(toNameId);
        Talk talk=new Talk();
        talk.setUserNameId(userNameId);
        talk.setToNameId(toNameId);
        talk.setUserName(user.getUsername());
        talk.setToName(toUser.getUsername());
        return talkMapper.insertTalk(talk);
    }
}
