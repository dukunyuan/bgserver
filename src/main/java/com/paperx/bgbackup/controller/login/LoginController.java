package com.paperx.bgbackup.controller.login;

import com.paperx.bgbackup.annotation.UserLoginToken;
import com.paperx.bgbackup.model.user.User;
import com.paperx.bgbackup.service.login.LoginService;
import com.paperx.bgbackup.service.token.TokenService;
import com.paperx.bgbackup.utils.HttpUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:8888",allowCredentials = "true")
@RestController
@RequestMapping
public class LoginController {
@Autowired
private LoginService loginService;
@Autowired
private TokenService tokenService;
    //登录
    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user){
        System.out.println(user.getUsername());
        Map<String,Object> map = loginService.check(user);
        //获取map中的用户信息
        user = (User) map.get("currentUser");
        request.getSession().setAttribute("currentUser",user);
        System.out.println(user);
        String token = tokenService.getToken(user);
        map.put("token",token);
        try {
            HttpUtils.responseMapSuccess(response, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/register")
    @UserLoginToken
    public void regist(HttpServletRequest request, HttpServletResponse response, User user){
        Map<String,Object> map = loginService.selectAll();
        //获取map中的用户信息
        //Map<String,Object> map = new HashMap<String,Object>();
        map.put("user","123");
        //System.out.println(user);
        try {
            HttpUtils.responseMapSuccess(response, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
