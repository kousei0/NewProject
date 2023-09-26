package com.example.myProject.controller;

import com.example.myProject.common.vo.Result;
import com.example.myProject.entity.Department;
import com.example.myProject.service.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@Api(tags = "部门")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public Result<List<Department>> departmentList() {
        List<Department> departmentList = departmentService.selectList();
        return Result.success(departmentList);
    }

    @GetMapping("/selectById")
    public Result<Department> selectById(Integer departmentid) {
        Department department = departmentService.selectById(departmentid);
        return Result.success(department);
    }

    @RequestMapping("/insertOne")
    @ResponseBody
    public void insertOne(Department department) {
        departmentService.insertOne(department);
    }

    @RequestMapping("/updateOne")
    @ResponseBody
    public void updateOne(Department departmentInput) {
        Department existingDepartment = departmentService.getById(departmentInput.getDepartmentid());

        updateFieldIfNotNull(existingDepartment, "department", departmentInput.getDepartment());
        updateFieldIfNotZero(existingDepartment, "number", departmentInput.getNumber());
        updateFieldIfNotNull(existingDepartment, "content", departmentInput.getContent());

        departmentService.updateOne(existingDepartment);
    }

    private void updateFieldIfNotNull(Department department, String fieldName, String value) {
        if (value != null) {
            try {
                Field field = Department.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(department, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateFieldIfNotZero(Department department, String fieldName, int value) {
        if (value != 0) {
            try {
                Field field = Department.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(department, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/deleteOne")
    public void deleteOne(Integer departmentid) {
        departmentService.deleteOne(departmentid);
    }
}
