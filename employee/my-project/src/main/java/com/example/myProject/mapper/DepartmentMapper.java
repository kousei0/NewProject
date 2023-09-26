package com.example.myProject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myProject.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> selectList();

    Department selectById(Integer departmentid);

    void insertOne(Department department);

    void updateOne(Department department);

    void deleteOne(Integer departmentid);
}

