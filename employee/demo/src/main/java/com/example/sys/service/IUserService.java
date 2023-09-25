package com.example.sys.service;

import com.example.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 123456
 * @since 2023-09-20
 */
public interface IUserService extends IService<User> {
    List<User> selectList();
}
