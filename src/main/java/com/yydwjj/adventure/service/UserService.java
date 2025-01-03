package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.Evaluation;
import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Result login(User user);

    Result register(User user);

    Result getLoginUserInfo(String token);

    Result update(User user);

    Result getUserInfo(int id);

    Result rant(String token, Evaluation evaluation);
}
