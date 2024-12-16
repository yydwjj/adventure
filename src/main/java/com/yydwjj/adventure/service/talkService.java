package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.Talk;
import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.result.Result;

public interface talkService {
    int insertTalk(int userNameId,int toNameId);
}