package com.paperx.bgbackup.service.register.impl;

import com.paperx.bgbackup.mapper.user.UserMapper;
import com.paperx.bgbackup.model.user.User;
import com.paperx.bgbackup.service.register.RegiserService;
import com.paperx.bgbackup.utils.UUIDUtils;
import com.paperx.bgbackup.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegiserServiceImpl implements RegiserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Map<String, Object> Register(User user) {
        Map<String,Object> map = new HashMap<String,Object>();
        //查询用户名是否重复
        List<User> users = userMapper.searchUser(user.getUsername());
        //查询邮箱是否重复
        List<User> usersEmail = userMapper.searchUserByEmail(user.getEmail());
        if (users != null && users.size()!=0){
            String msg = "用户名存在";
            map.put("msg",msg);
        }else if (usersEmail != null && usersEmail.size()!=0){
            String msg = "邮箱已经存在";
            map.put("msg",msg);
        }else {
            //注册新用户
            user.setId(UUIDUtils.uuid());
            Date createtime = DateUtils.dateTime();
            user.setCreatetime(createtime);
            //默认 普通用户 general
            user.setRole("general");
            userMapper.insert(user);
        }
        map.put("msg",new StringBuffer("注册成功"));
        return  map;
    }
}
