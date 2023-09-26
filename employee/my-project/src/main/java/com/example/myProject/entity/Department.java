package com.example.myProject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Department对象", description = "")
@TableName("department")
@Getter
@Setter
@Data
public class Department {
    private int departmentid;

    private String department;

    private int number;

    private String content;
}