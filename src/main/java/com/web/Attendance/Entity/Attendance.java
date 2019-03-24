package com.web.Attendance.Entity;

public class Attendance {
    public int id;
    public int user_id;
    public String user_name;
    public String attendance_status;
    public String attendance_date;
    public String attendance_time;
    public String reject_user_id;
    public String reject_content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAttendance_status() {
        return attendance_status;
    }

    public void setAttendance_status(String attendance_status) {
        this.attendance_status = attendance_status;
    }

    public String getAttendance_date() {
        return attendance_date;
    }

    public void setAttendance_date(String attendance_date) {
        this.attendance_date = attendance_date;
    }

    public String getAttendance_time() {
        return attendance_time;
    }

    public void setAttendance_time(String attendance_time) {
        this.attendance_time = attendance_time;
    }

    public String getReject_user_id() {
        return reject_user_id;
    }

    public void setReject_user_id(String reject_user_id) {
        this.reject_user_id = reject_user_id;
    }

    public String getReject_content() {
        return reject_content;
    }

    public void setReject_content(String reject_content) {
        this.reject_content = reject_content;
    }
}
