package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.Talk;
import com.yydwjj.adventure.mapper.talkMapper;
import com.yydwjj.adventure.result.Result;
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

    @GetMapping(value ="getAllTalk/{id}")
    public List<Talk> getAllTalk(@PathVariable int id){
        return  talkMapper.getAllTalk(id);
    }
}
