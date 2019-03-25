package com.web.Attendance.Mapper;

import com.web.Attendance.Entity.Attendance;

import java.util.List;
import java.util.Map;

public interface AttendanceMapper {
    void addAttendance(Attendance attInfo);

    List<Attendance> getAttendanceById(Integer user_id);

    List<Attendance> getAllAttendanceByDate(String attendance_date);

    void updateAttendanceStatusById(Map<String, Object> temp);

    Attendance getAttInfoById(Integer id);
}
