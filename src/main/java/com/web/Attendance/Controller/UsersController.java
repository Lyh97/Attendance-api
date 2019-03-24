package com.web.Attendance.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.Attendance.Entity.Users;
import com.web.Attendance.Service.UsersService;
import com.web.Attendance.tool.Md5;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UsersController {

    @Resource
    UsersService service;

    @RequestMapping(value = "/addUser", method = POST)
    public Map<String, Object> addUser(@RequestBody String userinfo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        JSONObject result = new JSONObject();

        Users user = JSON.parseObject(userinfo,Users.class);
        Md5 md5 = new Md5();
        user.setPassword(md5.encodeByMd5(user.getPassword()));
        user.setRole("0");

        service.addUser(user);

        result.put("status", 200);
        result.put("message", "用户添加成功");
        result.put("date", user);
        return result;
    }
}
