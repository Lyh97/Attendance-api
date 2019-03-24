package com.web.Attendance.Service;

import com.web.Attendance.Entity.Users;
import com.web.Attendance.Mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    LoginMapper mapper;

    public Users login(String userName) {
        return mapper.getUserByUsername(userName);
    }
}
