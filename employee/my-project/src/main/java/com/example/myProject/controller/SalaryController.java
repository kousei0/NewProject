package com.example.myProject.controller;

import com.example.myProject.common.vo.Result;
import com.example.myProject.entity.Salary;
import com.example.myProject.service.SalaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@Api(tags = "工资")
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/all")
    @ResponseBody
    public Result<List<Salary>> salaryList() {
        List<Salary> list = salaryService.selectList();
        return Result.success(list);
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Result<Salary> selectById(Integer salaryid) {
        Salary salary = salaryService.selectById(salaryid);
        return Result.success(salary);
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public Result<List<Salary>> selectByName(String name) {
        List<Salary> salaries = salaryService.selectByName(name);
        return Result.success(salaries);
    }

    @RequestMapping("/selectByDepartment")
    @ResponseBody
    public Result<List<Salary>> selectByDepartment(String department) {
        List<Salary> salaries = salaryService.selectByDepartment(department);
        return Result.success(salaries);
    }

    @RequestMapping("/selectByMonth")
    @ResponseBody
    public Result<List<Salary>> selectByMonth(String month) {
        List<Salary> salaries = salaryService.selectByMonth(month);
        return Result.success(salaries);
    }

    @RequestMapping("/insertOne")
    @ResponseBody
    public void insertOne(Salary salary) {
        salaryService.insertOne(salary);
    }

    @RequestMapping("/updateOne")
    @ResponseBody
    public void updateOne(Salary salaryInput) {
        Salary existingSalary = salaryService.getById(salaryInput.getSalaryid());

        updateFieldIfNotNull(existingSalary, "name", salaryInput.getName());
        updateFieldIfNotNull(existingSalary, "department", salaryInput.getDepartment());
        updateFieldIfNotNull(existingSalary, "month", salaryInput.getMonth());
        updateFieldIfNotNull(existingSalary, "basicSalary", salaryInput.getBasicSalary());
        updateFieldIfNotNull(existingSalary, "allowance", salaryInput.getAllowance());
        updateFieldIfNotNull(existingSalary, "tax", salaryInput.getTax());
        updateFieldIfNotNull(existingSalary, "afterTax", salaryInput.getAfterTax());

        salaryService.updateOne(existingSalary);
    }

    private void updateFieldIfNotNull(Salary salary, String fieldName, Object value) {
        if (value != null) {
            try {
                Field field = Salary.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(salary, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/deleteOne")
    @ResponseBody
    public void deleteOne(Integer salaryid) {
        salaryService.deleteOne(salaryid);
    }
}
