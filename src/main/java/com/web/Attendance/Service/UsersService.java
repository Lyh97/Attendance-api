package com.web.Attendance.Service;

import com.web.Attendance.Entity.Users;
import com.web.Attendance.Mapper.UsersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersService {

    @Resource
    UsersMapper mapper;

    public void addUser(Users user) {
        mapper.addUser(user);
    }
}
