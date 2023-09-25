package com.example.sys.mapper;

import com.example.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 123456
 * @since 2023-09-20
 */
public interface UserMapper extends BaseMapper<User> {
    // 查询所有记录
    List<User> selectList();

//    // 根据主键查询记录
//    User selectById(Long id);
//
//    // 插入记录
//    int insert(User user);
//
//    // 根据主键更新记录
//    int updateById(User user);
//
//    // 根据主键删除记录
//    void deleteById(Long id);
}
