package com.example.myProject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myProject.entity.Salary;

import java.util.List;

public interface SalaryService extends IService<Salary> {

    List<Salary> selectList();

    Salary selectById(Integer salaryid);

    List<Salary> selectByName(String name);

    List<Salary> selectByDepartment(String department);

    List<Salary> selectByMonth(String month);

    void insertOne(Salary salary);

    void updateOne(Salary salary);

    void deleteOne(Integer salaryid);
}
