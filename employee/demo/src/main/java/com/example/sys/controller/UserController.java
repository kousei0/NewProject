package com.example.sys.controller;

import ch.qos.logback.core.model.Model;
import com.example.sys.entity.User;
import com.example.sys.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 123456
 * @since 2023-09-20
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/all")
    public List<User> users() {
        List<User> users = userService.selectList();
        return users;
    }

}
