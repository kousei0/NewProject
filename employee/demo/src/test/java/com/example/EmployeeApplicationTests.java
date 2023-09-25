package com.example;

import com.example.sys.entity.User;
import com.example.sys.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.example.*.mapper")
class EmployeeApplicationTests {

    @Test
    void testMapper() {

    }

}
