package com.example.myProject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel(value = "Attendance对象", description = "")
@TableName("attendance")
@Getter
@Setter
@Data
public class Attendance {
    private int attendanceid;

    private String cause;

    private String name;

    private String department;

    private Date start;

    private Date end;
}
