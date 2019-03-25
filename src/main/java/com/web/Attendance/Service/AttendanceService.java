package com.web.Attendance.Service;

import com.web.Attendance.Entity.Attendance;
import com.web.Attendance.Mapper.AttendanceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceService {

    @Resource
    AttendanceMapper mapper;

    public void addAttendance(Attendance attInfo) {
        mapper.addAttendance(attInfo);
    }

    public List<Attendance> getAttendanceById(Integer id) {
        return mapper.getAttendanceById(id);
    }

    public List<Attendance> getAllAttendanceByDate(String date) {
        return mapper.getAllAttendanceByDate(date);
    }

    public void updateAttendanceStatusById(Map<String, Object> temp) {
        mapper.updateAttendanceStatusById(temp);
    }

    public Attendance getAttInfoById(Integer id) {
        return mapper.getAttInfoById(id);
    }
}
