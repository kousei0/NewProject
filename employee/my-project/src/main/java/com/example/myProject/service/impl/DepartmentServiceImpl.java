package com.example.myProject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myProject.entity.Department;
import com.example.myProject.mapper.DepartmentMapper;
import com.example.myProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectList() {
        return departmentMapper.selectList();
    }

    @Override
    public Department selectById(Integer departmentid) {
        return departmentMapper.selectById(departmentid);
    }

    @Override
    public void insertOne(Department department) {
        departmentMapper.insertOne(department);
    }

    @Override
    public void updateOne(Department department) {
        departmentMapper.updateOne(department);
    }

    @Override
    public void deleteOne(Integer departmentid) {
        departmentMapper.deleteOne(departmentid);
    }
}
