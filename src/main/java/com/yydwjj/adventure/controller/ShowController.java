package com.yydwjj.adventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
//@RequestMapping("show")
public class ShowController {
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String test() {
//        System.out.println("aaa");
        return "forward:/indexNew.html";
    }

    /**
     * 登录页
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
//        System.out.println("aaa");
        return "forward:/login.html";
    }

    /**
     * 任务发布页
     * @return
     */
    @RequestMapping(value = "post-task",method = RequestMethod.GET)
    public String postTask(){
        return "forward:/post.html";
    }

    /**
     * 个人信息页
     */
    @GetMapping(value = "profile")
    public String profile(){
        return "forward:/presonifm.html";
    }

    @GetMapping(value = "taskinfo/{taskId}")
    public String taskInfo(@PathVariable int taskId){
        return "forward:/taskinfo.html";
    }
    @GetMapping(value = "createTeam/{taskId}")
    public String createTeam(@PathVariable int taskId){
        return "forward:/createTeam.html";
    }

    @GetMapping(value = "postJob/{teamId}")
    public String postJob(@PathVariable int teamId){
        return "forward:/post-job.html";
    }
}
