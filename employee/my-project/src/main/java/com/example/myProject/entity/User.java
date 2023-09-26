package com.example.myProject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value = "User对象", description = "")
@TableName("user")
@Getter
@Setter
@Data
public class User {
    private static final long serialVersionUID = 1L;

    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;

    private String username;

    private String password;

    private Boolean identity;

    private String name;

    private String gender;

    private LocalDate birth;

    private String address;

    private String phone;

    private String mail;

    private String department;

    private String position;

}
