package com.web.Attendance.Mapper;

import com.web.Attendance.Entity.Users;

import java.util.List;

public interface UsersMapper {
    void addUser(Users user);

    Users getUserInfoById(int id);

    void deleteUserInfoById(int id);

    void updateUserInfoById(Users user);

    List<Users> getAllUserInfo();
}
