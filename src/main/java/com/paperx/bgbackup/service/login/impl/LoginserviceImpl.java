package com.paperx.bgbackup.service.login.impl;

import com.paperx.bgbackup.mapper.user.UserMapper;
import com.paperx.bgbackup.model.user.User;
import com.paperx.bgbackup.service.login.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LoginserviceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Map<String, Object> check(User user) {
        //提示信息
       String msg ="";
       Map<String,Object> map = new HashMap<String,Object>();
//        //查用户
        List<User> users = userMapper.searchUser(user.getUsername());
        if (users != null && users.size() > 0){
            User dbUser = users.get(0);
//            //密码验证
            String inputPassword = user.getPassword();
            if (inputPassword.equalsIgnoreCase(dbUser.getPassword())){
                map.put("currentUser",dbUser);
            }else{
                msg = "用户名或密码错误";
            }
        } else {
            msg = "用户不存在";
        }
        map.put("msg",msg);

        return  map;
    }

    @Override
    public Map<String, Object> selectAll() {
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println(123);
        List<User> users = userMapper.selectAll();
        map.put("users",users);
        return map;
    }
}
