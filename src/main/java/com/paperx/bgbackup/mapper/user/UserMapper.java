package com.paperx.bgbackup.mapper.user;

import com.paperx.bgbackup.model.user.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<User> searchUser(String username);

    List<User> searchUserByEmail(String email);
}