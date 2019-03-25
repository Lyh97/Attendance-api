package com.web.Attendance.Service;

import com.web.Attendance.Entity.Users;
import com.web.Attendance.Mapper.UsersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsersService {

    @Resource
    UsersMapper mapper;

    public void addUser(Users user) {
        mapper.addUser(user);
    }

    public Users getUserInfoById(int id) {
        return mapper.getUserInfoById(id);
    }

    public void deleteUserInfoById(int id) {
        mapper.deleteUserInfoById(id);
    }

    public void updateUserInfoById(Users id) {
        mapper.updateUserInfoById(id);
    }

    public List<Users> getAllUserInfo() {
        return mapper.getAllUserInfo();
    }
}
