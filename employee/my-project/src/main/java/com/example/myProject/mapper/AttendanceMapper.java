package com.example.myProject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myProject.entity.Attendance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {

    List<Attendance> selectList();

    Attendance selectById(Integer attendanceid);

    List<Attendance> selectByName(String name);

    List<Attendance> selectByDepartment(String department);

    void insertOne(Attendance attendance);

    void updateOne(Attendance attendance);

    void deleteOne(Integer attendanceid);
}

