package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户的登录接口，若登陆成功，在result中包含一个<token,JWTtoken>,需要在客户端保存，并在之后的操作中，在请求头(RequestHead)中携带，用来识别用户
     * @param user
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Result test(@RequestBody User user) {
        Result result = userService.login(user);
        return result;
    }

    /**
     * 用户的注册接口，需要携带用户的用户名，电话，密码
     * @param user
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user) {
        Result result = userService.register(user);
        return result;
    }

    /**
     * 获取操作用户信息的接口，需要在RequestHeader中携带JWTtoken
     * @param token
     * @return
     */
    @RequestMapping(value = "getUserInfo" ,method = RequestMethod.GET)
    public Result getUserInfo(@RequestHeader String token) {
        Result result = userService.getUserInfo(token);
        return result;
    }
}