package com.yydwjj.adventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping("show")
public class ShowController {
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String test() {
//        System.out.println("aaa");
        return "redirect:/indexNew.html";
    }

    /**
     * 登录页
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
//        System.out.println("aaa");
        return "redirect:/login.html";
    }

    /**
     * 任务发布页
     * @return
     */
    @RequestMapping(value = "post-task",method = RequestMethod.GET)
    public String postTask(){
        return "redirect:/post.html";
    }

    /**
     * 个人信息页
     */
    @GetMapping(value = "profile")
    public String profile(){
        return "redirect:/presonifm.html";
    }

}
