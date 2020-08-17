package com.paperx.bgbackup.service.user.impl;

import com.paperx.bgbackup.mapper.user.UserMapper;
import com.paperx.bgbackup.model.user.User;
import com.paperx.bgbackup.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User findByUsername(User user) {
        return userMapper.searchUser(user.getUsername()).get(0);
    }

    @Override
    public User findUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
