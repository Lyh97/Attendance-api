package com.web.Attendance.Controller;

import com.alibaba.fastjson.JSON;
import com.web.Attendance.Entity.Users;
import com.web.Attendance.Service.LoginService;
import com.web.Attendance.tool.Md5;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LoginController {

    @Resource
    LoginService service;

    @RequestMapping(value = "/login", method = POST)
    public Map<String, Object> login(@RequestBody String info) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String userName = JSON.parseObject(info).get("userName").toString();
        String password = JSON.parseObject(info).get("password").toString();
        Md5 md5 = new Md5();

        Users user = service.login(userName);

        Map<String, Object> result = new HashMap();
        if(user != null) {
            if(user.getPassword().equals(md5.encodeByMd5(password))) {
                result.put("status", 200);
                result.put("message", "登陆成功");
                result.put("data", user);
            } else {
                result.put("status", 301);
                result.put("message", "密码错误");
                result.put("data", "");
            }
        } else {
            result.put("status", 302);
            result.put("message", "无此用户");
            result.put("data", "");
        }

        return result;
    }
}
