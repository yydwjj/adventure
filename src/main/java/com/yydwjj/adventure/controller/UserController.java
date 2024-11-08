package com.yydwjj.adventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String test(@RequestParam("username") String username, @RequestParam("password") String password) {
        return "success";
    }
}
