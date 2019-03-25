package com.web.Attendance.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.Attendance.Entity.Users;
import com.web.Attendance.Service.UsersService;
import com.web.Attendance.tool.Md5;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UsersController {

    @Resource
    UsersService service;

    @RequestMapping(value = "/addUser", method = POST)
    public Map<String, Object> addUser(@RequestBody String userinfo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Map<String, Object> result = new HashMap();

        Users user = JSON.parseObject(userinfo,Users.class);
        Md5 md5 = new Md5();
        user.setPassword(md5.encodeByMd5(user.getPassword()));
        user.setRole("0");

        if(service.getUserInfoById(user.getId()) != null) {
            result.put("status", 301);
            result.put("message", "用户已存在");
            result.put("data", "");
            return result;
        }
        service.addUser(user);

        result.put("status", 200);
        result.put("message", "用户添加成功");
        result.put("data", user);
        return result;
    }

    @RequestMapping(value = "/deleteUserInfoById", method = GET)
    public Map<String, Object> deleteUserInfoById(@RequestParam Integer id) {
        Map<String, Object> result = new HashMap();

        if(service.getUserInfoById(id) == null) {
            result.put("status", 301);
            result.put("message", "用户不存在");
            result.put("data", "");
        } else {
            service.deleteUserInfoById(id);
            result.put("status", 200);
            result.put("message", "用户删除成功");
            result.put("data", "");
        }
        return result;
    }

    @RequestMapping(value = "/updateUserInfoById", method = POST)
    public Map<String, Object> updateUserInfoById(@RequestBody String userInfo) {
        Map<String, Object> result = new HashMap();
        Users user = JSONObject.parseObject(userInfo, Users.class);
        if(service.getUserInfoById(user.getId()) == null) {
            result.put("status", 301);
            result.put("message", "用户不存在");
            result.put("data", "");
        } else {
            service.updateUserInfoById(user);
            result.put("status", 200);
            result.put("message", "用户修改成功");
            result.put("data", "");
        }

        return result;
    }

    @RequestMapping(value = "/getUserInfoById", method = GET)
    public Map<String, Object> getUserInfoById(@RequestParam Integer id) {
        Map<String, Object> result = new HashMap();

        Users user = service.getUserInfoById(id);
        if(user != null) {
            result.put("status", 200);
            result.put("message", "用户查询成功");
            result.put("data", user);
            return result;
        } else {
            result.put("status", 301);
            result.put("message", "无此用户");
            result.put("data", "");
            return result;
        }
    }

    @RequestMapping(value = "/getAllUserInfo", method = GET)
    public Map<String, Object> getAllUserInfo() {
        Map<String, Object> result = new HashMap();

        List<Users> list = service.getAllUserInfo();

        result.put("status", 200);
        result.put("message", "全部职员");
        result.put("data", list);

        return result;
    }

}
