package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *  User 调用持久层
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where phone_number like #{phoneNumber}")
    User getUserByPhone(String phoneNumber);


    @Insert("INSERT INTO user(username, user_pwd, phone_number, created_at, updated_at, user_avatar_id) " +
            "VALUES(#{username}, #{userPwd}, #{phoneNumber}, #{createdAt}, #{updatedAt}, #{userAvatarId})")
    int add(User user);

    @Select("Select max(user.user_id) from user")
    long getMaxUid();

    @Select("select * from user where user_id = #{userId}")
    User selectById(Long userId);

    @Update("UPDATE adventure.user SET username = #{username} ,email = #{email}," +
                    "phone_number = #{phoneNumber},updated_at = NOW(),notes = #{notes}," +
                    " school_id = #{schoolId} WHERE user_id = #{userId}")
    int updateById(User user);
}
