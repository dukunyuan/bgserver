package com.paperx.bgbackup.controller.login;

import com.paperx.bgbackup.model.user.User;
import com.paperx.bgbackup.service.login.LoginService;
import com.paperx.bgbackup.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping
public class LoginController {
@Autowired
private LoginService loginService;
    //登录
    @PostMapping("login")
    public void login(HttpServletRequest request, HttpServletResponse response, User user){
        Map<String,Object> map = loginService.check(user);
        //获取map中的用户信息
        user = (User) map.get("currentUser");
        request.getSession().setAttribute("currentUser",user);
        try {
            HttpUtils.responseMapSuccess(response, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
