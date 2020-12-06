package com.paperx.bgbackup.controller.register;

import com.paperx.bgbackup.annotation.PassToken;
import com.paperx.bgbackup.model.user.User;
import com.paperx.bgbackup.service.register.RegiserService;
import com.paperx.bgbackup.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping
public class RegisterController {
    @Autowired
    private RegiserService regiserService;
    @PassToken
    //注册
    @PostMapping("register")
    public void Register (HttpServletRequest request, HttpServletResponse response, @RequestBody User user){
        Map<String,Object> map = regiserService.Register(user);
        try {
            HttpUtils.responseMapSuccess(response, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
