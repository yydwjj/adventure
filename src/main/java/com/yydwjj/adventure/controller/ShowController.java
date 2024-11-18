package com.yydwjj.adventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping("show")
public class ShowController {
    /**
     * 重定向到首页
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String test() {
//        System.out.println("aaa");
        return "redirect:/indexNew.html";
    }

    /**
     * 重定向到登录页
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
//        System.out.println("aaa");
        return "redirect:/login.html";
    }


    @RequestMapping(value = "post-task",method = RequestMethod.GET)
    public String postTask(){
        return "redirect:/post.html";
    }

}
