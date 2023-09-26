package com.example.myProject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myProject.entity.Salary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalaryMapper extends BaseMapper<Salary> {

    List<Salary> selectList();

    Salary selectById(Integer salaryid);

    List<Salary> selectByName(String name);

    List<Salary> selectByDepartment(String department);

    List<Salary> selectByMonth(String month);

    void insertOne(Salary salary);

    void updateOne(Salary salary);

    void deleteOne(Integer salaryid);
}
