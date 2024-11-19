package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.mapper.UserMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.result.ResultCodeEnum;
import com.yydwjj.adventure.service.UserService;
import com.yydwjj.adventure.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    JwtHelper jwtHelper;


    /**
     * 登录业务
     *      登录成功
     *      登录失败
     *      用户不存在或已注销
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {

        User userByPhone = userMapper.getUserByPhone(user.getPhoneNumber());
        if(userByPhone != null){
            if(userByPhone.getDeletedAt()!=null){
                //用户不存在或已删除
                if(userByPhone.getDeletedAt().after(new Date(System.currentTimeMillis())))
                    return Result.build(null,ResultCodeEnum.NOTLOGIN);
            } else if (!user.getUserPwd().equals(userByPhone.getUserPwd())) {
                //用户密码错误
                return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
            } else {
                String token = jwtHelper.createToken(Long.valueOf(userByPhone.getUserId()));
                Map<String,String> data = new HashMap<>();
                data.put("token",token);
                return Result.ok(data);
            }
        }
        return Result.build(null, ResultCodeEnum.NOTLOGIN);
    }

    /**
     * 提供 用户名，密码，电话
     * 在程序中提供   id 创建时间 修改时间
     * 注册业务
     *      验证电话是否已经被使用
     *          电话从未被使用过
     *          电话使用过，但是账号已经注销
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {
        User existingUser = userMapper.getUserByPhone(user.getPhoneNumber());
        //电话号已被使用的判断
        if (existingUser != null && existingUser.getDeletedAt() == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        // 电话号可以使用，执行添加操作
        //添加数据库非空值
//        user.setUserId(userMapper.getMaxUid()+1);
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userMapper.add(user);
        return Result.build(user, ResultCodeEnum.SUCCESS); // 直接返回添加的用户和成功状态
    }

    @Override
    public Result getUserInfo(String token) {
        Result result = null;
        if(!jwtHelper.isExpiration(token)){
            //token已经失效
            result = Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
        Long userId = jwtHelper.getUserId(token);

        User user = userMapper.selectById(userId);
        if(user == null){
            result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }
        else{
            user.setUserPwd("");
            Map<String,User> data = new HashMap<>();
            data.put("loginUser",user);
            result = Result.ok(data);
        }
        return result;
    }
}