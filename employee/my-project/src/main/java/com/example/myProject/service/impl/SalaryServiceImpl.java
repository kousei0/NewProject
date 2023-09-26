package com.example.myProject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myProject.entity.Salary;
import com.example.myProject.mapper.SalaryMapper;
import com.example.myProject.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public List<Salary> selectList() {
        return salaryMapper.selectList();
    }

    @Override
    public Salary selectById(Integer salaryid) {
        return salaryMapper.selectById(salaryid);
    }

    @Override
    public List<Salary> selectByName(String name) {
        return salaryMapper.selectByName(name);
    }

    @Override
    public List<Salary> selectByDepartment(String department) {
        return salaryMapper.selectByDepartment(department);
    }

    @Override
    public List<Salary> selectByMonth(String month) {
        return salaryMapper.selectByMonth(month);
    }

    @Override
    public void insertOne(Salary salary) {
        salaryMapper.insertOne(salary);
    }

    @Override
    public void updateOne(Salary salary) {
        salaryMapper.updateOne(salary);
    }

    @Override
    public void deleteOne(Integer salaryid) {
        salaryMapper.deleteOne(salaryid);
    }
}
