package com.example.myProject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myProject.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService extends IService<User> {
    List<User> selectList();

    Map<String, Object> login(User user);

    User selectById(Integer userid);

    List<User> selectByName(String name);

    List<User> selectByDepartment(String department);

    void insertOne(User user);

    void updateOne(User user);

    void deleteOne(User user);
}
