package com.web.Attendance.Controller;

import com.web.Attendance.Entity.Attendance;
import com.web.Attendance.Entity.Users;
import com.web.Attendance.Service.AttendanceService;
import com.web.Attendance.Service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class AttendanceController {

    @Resource
    AttendanceService attservice;
    @Resource
    UsersService userService;

    @RequestMapping(value = "/attendance", method = GET)
    public Map<String, Object> attendance(@RequestParam Integer id) {
        Map<String, Object> result = new HashMap();

        Users user = userService.getUserInfoById(id);

        Attendance attInfo = new Attendance();

        attInfo.setUser_id(user.getId());
        attInfo.setUser_name(user.getName());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        attInfo.setAttendance_date(date.format(new Date()));
        attInfo.setAttendance_time(time.format(new Date()));
        attInfo.setAttendance_status("success");

        attservice.addAttendance(attInfo);

        result.put("status", 200);
        result.put("message", "签到成功");

        return result;
    }

    @RequestMapping(value = "/updateAttendanceStatusById", method = GET)
    public Map<String, Object> updateAttendanceStatusById(@RequestParam Integer id, @RequestParam String status) {
        Map<String, Object> result = new HashMap();
        Map<String, Object> temp = new HashMap();

        if(attservice.getAttInfoById(id) == null) {
            result.put("status", 301);
            result.put("message", "无此签到信息");
            return result;
        }
        temp.put("id", id);
        temp.put("attendance_status", status);

        attservice.updateAttendanceStatusById(temp);

        result.put("status", 200);
        result.put("message", "该职员签到信息修改成功");

        return result;
    }

    @RequestMapping(value = "/getAllAttendanceByDate", method = GET)
    public Map<String, Object> getAllAttendanceByDate(@RequestParam String date) {
        Map<String, Object> result = new HashMap();

        if(date.equals("") || date == null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.format(new Date());
        }
        List<Attendance> list = attservice.getAllAttendanceByDate(date);

        result.put("status", 200);
        result.put("message", "所有职员日期当日签到信息");
        result.put("data", list);

        return result;
    }

    @RequestMapping(value = "/getAttendanceById", method = GET)
    public Map<String, Object> getAttendanceById(@RequestParam Integer id) {
        Map<String, Object> result = new HashMap();

        List<Attendance> list = attservice.getAttendanceById(id);

        result.put("status", 200);
        result.put("message", "职员签到信息");
        result.put("data", list);

        return result;
    }


}
