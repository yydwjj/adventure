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

    @GetMapping(value = "tasks")
    public String competition(){
        return "forward:/competition.html";
    }

    /**
     * 队伍列表页
     * @return  请求转发到队伍列表页
     */
    @GetMapping(value = "team")
    public String team(){
        return "forward:/team.html";
    }

    /**
     * 队伍详情页
     * @param teamid    要查看的队伍id
     * @return  请求转发到队伍该id的队伍详情
     */
    @GetMapping(value = "teaminfo/{teamid}")
    public String teamInfo(@PathVariable int teamid){
        return "forward:/teaminfo.html";
    }

    /**
     * 对话页
     * @return  请求转发到对话页
     */
    @GetMapping(value = "teaminfo/{teamid}/talk/{uid}")
    public String talk(){
        return "forward:/talk.html";
    }

    /**
     * 人才列表页
     * @return 请求转发到人才列表页
     */
    @GetMapping(value = "talent")
    public String talent(){
        return "forward:/talent.html";
    }


}
