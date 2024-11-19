package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Result login(User user);

    Result register(User user);

    Result getUserInfo(String token);

    Result update(User user);
}
