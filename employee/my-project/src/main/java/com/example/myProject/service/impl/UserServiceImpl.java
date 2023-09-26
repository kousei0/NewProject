package com.example.myProject.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myProject.entity.User;
import com.example.myProject.mapper.UserMapper;
import com.example.myProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Qualifier("redisTemplate")

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> selectList(){
        return userMapper.selectList();
    }

    @Override
    public Map<String, Object> login(User user) {
        //查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.eq(User::getUsername,user.getUsername());
        wrapper.eq(User::getPassword,user.getPassword());
        User loginUser = this.getOne(wrapper);
        //存入redis
        if(loginUser != null){
            Map<String, Object> data = new HashMap<>();
            String key = "user::" + UUID.randomUUID();
            data.put("token", key);    // 待优化，最终方案jwt
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);
            return data;
        }
        return null;
    }

    @Override
    public User selectById(Integer userid) {
        return userMapper.selectById(userid);
    }

    @Override
    public List<User> selectByName(String name) {
        List<User> userList = userMapper.selectByName(name);
        return userList;
    }

    @Override
    public List<User> selectByDepartment(String department) {
        List<User> userList = userMapper.selectByDepartment(department);
        return userList;
    }

    @Override
    public void insertOne(User user) {
        userMapper.insertOne(user);
    }

    @Override
    public void updateOne(User user) {
        userMapper.updateOne(user);
    }

    @Override
    public void deleteOne(User user) {
        userMapper.deleteOne(user);
    }


}
