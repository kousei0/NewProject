package com.example.myProject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myProject.entity.Attendance;

import java.util.List;
import java.util.Map;

public interface AttendanceService extends IService<Attendance> {
    List<Attendance> selectList();

    Attendance selectById(Integer attendanceid);

    List<Attendance> selectByName(String name);

    List<Attendance> selectByDepartment(String department);

    void insertOne(Attendance attendance);

    void updateOne(Attendance attendance);

    void deleteOne(Integer attendanceid);
}
