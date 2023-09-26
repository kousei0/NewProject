package com.example.myProject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@ApiModel(value = "Salary对象", description = "")
@TableName("salary")
@Getter
@Setter
@Data
public class Salary {
    private int salaryid;

    private String name;

    private String department;

    private String month;

    private BigDecimal basicSalary;

    private BigDecimal allowance;

    private BigDecimal tax;

    private BigDecimal afterTax;
}
