package com.paperx.bgbackup.service.register;

import com.paperx.bgbackup.model.user.User;

import java.util.Map;

public interface RegiserService {
    //注册
    Map<String,Object> Register(User user);
}
