package com.web.Attendance.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.Attendance.Entity.Comment;
import com.web.Attendance.Entity.Publicty;
import com.web.Attendance.Service.PublictyService;
import com.web.Attendance.Service.UsersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PublictyController {

    @Resource
    PublictyService publictyservice;
    @Resource
    UsersService userservice;

    @RequestMapping(value = "/addPublictyInfo", method = POST)
    public Map<String, Object> addPublictyInfo(@RequestBody String info) {
        JSONObject result = new JSONObject();

        Publicty publictyInfo = JSON.parseObject(info, Publicty.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        publictyInfo.setIssue_date(df.format(new Date()));

        publictyservice.addPublictyInfo(publictyInfo);

        result.put("status", 200);
        result.put("message", "公示添加成功");

        return result;
    }

    @RequestMapping(value = "/deletePublictyById", method = GET)
    public JSONObject deletePublictyById(@RequestParam Integer id) {

        JSONObject result = new JSONObject();

        if(publictyservice.getPublictyById(id) == null) {
            result.put("status", 301);
            result.put("message", "无此公告");

            return result;
        }

        publictyservice.deletePublictyById(id);

        result.put("status", 200);
        result.put("message", "公示删除成功");

        return result;

    }

    @RequestMapping(value = "/updatePublictyById", method = POST)
    public JSONObject updatePublictyById(@RequestBody String info) {
        JSONObject result = new JSONObject();

        Publicty publicty = JSON.parseObject(info, Publicty.class);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        publicty.setIssue_date(date.format(new Date()));

        if(publictyservice.getPublictyById(publicty.getId()) == null) {
            result.put("status", 301);
            result.put("message", "无此公告");

            return result;
        }

        try {
            publictyservice.updatePublictyById(publicty);
        } catch( Exception e ) {
            result.put("status", 301);
            result.put("message", e.getMessage().toString());

            return result;
        }
        result.put("status", 200);
        result.put("message", "公示修改成功");

        return result;
    }

    @RequestMapping(value = "/updatePublictyStatusById", method = GET)
    public JSONObject updatePublictyStatus(@RequestParam int id, @RequestParam int status) {
        JSONObject result = new JSONObject();
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("status", status);

        try {
            publictyservice.updatePublictyStatusById(map);
        } catch(Exception e) {
            result.put("status", 301);
            result.put("message", e.getMessage().toString());

            return result;
        }

        result.put("status", 200);
        result.put("message", "状态修改成功");

        return result;

    }

    @RequestMapping(value = "/getPublicty", method = GET)
    public JSONObject getPublicty() {
        JSONObject result = new JSONObject();

        List<Publicty> list = publictyservice.getPublicty();

        result.put("status", 200);
        result.put("message", "所有公示信息");
        result.put("data", list);

        return result;
    }

    @RequestMapping(value = "/getPublictyInfoById", method = GET)
    public JSONObject getPublictyInfoById(@RequestParam String userId) {
        JSONObject result = new JSONObject();

        if(userId.equals("") || userId == null) {
            result.put("status", 301);
            result.put("message", "无用户ID");
            result.put("data", "");

            return result;
        }
        List<Publicty> list = publictyservice.getPublictyInfoById(userId);

        result.put("status", 200);
        result.put("message", "所有公示信息");
        result.put("data", list);

        return result;
    }

    @RequestMapping(value = "/addComment", method = POST)
    public JSONObject addCommentByPublictyId(@RequestBody String comment) {
        JSONObject result = new JSONObject();
        Comment info = JSONObject.parseObject(comment, Comment.class);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        info.setDatetime(df.format(new Date()));

        try {
            publictyservice.addCommentByPublictyId(info);
        } catch(Exception e) {
            result.put("status", 301);
            result.put("message", "留言失败");
            return result;
        }

        result.put("status", 200);
        result.put("message", "留言成功");
        return result;
    }

    @RequestMapping(value = "/getCommentByPublictyId", method = GET)
    public JSONObject getCommentByPublictyId(@RequestParam Integer publictyId) {
        JSONObject result = new JSONObject();
        List<Comment> list = new ArrayList<>();

        try {
            list = publictyservice.getCommentByPublictyId(publictyId);
        } catch(Exception e) {
            result.put("status", 301);
            result.put("message", e.getMessage());
            return result;
        }

        result.put("status", 200);
        result.put("message", "按照公告ID获取评论信息");
        result.put("data", list);
        return result;
    }
}
