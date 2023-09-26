package com.example.myProject.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myProject.entity.Attendance;
import com.example.myProject.mapper.AttendanceMapper;
import com.example.myProject.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {

    @Autowired
    AttendanceMapper attendanceMapper;

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Attendance> selectList() {
        return attendanceMapper.selectList();
    }

    @Override
    public Attendance selectById(Integer attendanceid) {
        return attendanceMapper.selectById(attendanceid);
    }

    @Override
    public List<Attendance> selectByName(String name) {
        List<Attendance> attendanceList = attendanceMapper.selectByName(name);
        return attendanceList;
    }

    @Override
    public List<Attendance> selectByDepartment(String department) {
        List<Attendance> attendanceList = attendanceMapper.selectByDepartment(department);
        return attendanceList;
    }

    @Override
    public void insertOne(Attendance attendance) {
        attendanceMapper.insertOne(attendance);
    }

    @Override
    public void updateOne(Attendance attendance) {
        attendanceMapper.updateOne(attendance);
    }

    @Override
    public void deleteOne(Integer attendanceid) {
        attendanceMapper.deleteOne(attendanceid);
    }
}
