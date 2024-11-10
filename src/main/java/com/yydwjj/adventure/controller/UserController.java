package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Result test(@RequestBody User user) {
        Result result = userService.login(user);
        return result;
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user) {
        Result result = userService.register(user);
        return result;
    }

    @RequestMapping(value = "getUserInfo" ,method = RequestMethod.GET)
    public Result getUserInfo(@RequestHeader String token) {
        Result result = userService.getUserInfo(token);
        return result;
    }
}
