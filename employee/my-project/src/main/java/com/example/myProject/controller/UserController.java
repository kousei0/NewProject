package com.example.myProject.controller;

import com.example.myProject.common.vo.Result;
import com.example.myProject.entity.User;
import com.example.myProject.mapper.UserMapper;
import com.example.myProject.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/all")
    @ResponseBody
    public Result<List<User>> userList() {
        List<User> list = userService.selectList();
        return Result.success(list);
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String,Object> data = userService.login(user);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误");
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Result<User> selectById(Integer userid) {
        User user= userService.selectById(userid);
        return Result.success(user);
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public Result<List<User>> selectByName(String name) {
        List<User> users =  userService.selectByName(name);
        return Result.success(users);
    }

    @RequestMapping("/selectByDepartment")
    @ResponseBody
    public Result<List<User>> selectByDepartment(String department) {
        List<User> users = userService.selectByDepartment(department);
        return Result.success(users);
    }

    @RequestMapping("/insertOne")
    @ResponseBody
    public void insertOne(User user) {
        userService.insertOne(user);
    }

    @RequestMapping("/updateOne")
    @ResponseBody
    public void updateOne(User userInput) {
        User existingUser = userService.getById(userInput.getUserid());

        updateFieldIfNotNull(existingUser, "username", userInput.getUsername());
        updateFieldIfNotNull(existingUser, "password", userInput.getPassword());
        updateFieldIfNotNull(existingUser, "identity", userInput.getIdentity());
        updateFieldIfNotNull(existingUser, "name", userInput.getName());
        updateFieldIfNotNull(existingUser, "gender", userInput.getGender());
        updateFieldIfNotNull(existingUser, "birth", userInput.getBirth());
        updateFieldIfNotNull(existingUser, "address", userInput.getAddress());
        updateFieldIfNotNull(existingUser, "phone", userInput.getPhone());
        updateFieldIfNotNull(existingUser, "mail", userInput.getMail());
        updateFieldIfNotNull(existingUser, "department", userInput.getDepartment());
        updateFieldIfNotNull(existingUser, "position", userInput.getPosition());

        userService.updateOne(existingUser);
    }

    private void updateFieldIfNotNull(User user, String fieldName, Object value) {
        if (value != null) {
            try {
                Field field = User.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(user, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/deleteOne")
    @ResponseBody
    public void deleteOne(User user) {
        userService.deleteOne(user);
    }

}
