package com.example.myProject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myProject.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectList();

    User selectById(Integer userid);

    List<User> selectByName(String name);

    List<User> selectByDepartment(String department);

    void insertOne(User user);

    void updateOne(User user);

    void deleteOne(User user);
}
