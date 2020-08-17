package com.paperx.bgbackup.service.login;

import com.paperx.bgbackup.model.user.User;

import java.util.Map;


public interface LoginService {
    Map<String, Object> check(User user);//校验用户
    Map<String, Object> selectAll();
}
