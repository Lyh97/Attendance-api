package com.web.Attendance.Mapper;

import com.web.Attendance.Entity.Users;

public interface LoginMapper {
    Users getUserByUsername(String userName);
}
