package com.example.myProject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myProject.entity.Department;

import java.util.List;

public interface DepartmentService extends IService<Department> {
    List<Department> selectList();

    Department selectById(Integer departmentid);

    void insertOne(Department department);

    void updateOne(Department department);

    void deleteOne(Integer departmentid);
}
