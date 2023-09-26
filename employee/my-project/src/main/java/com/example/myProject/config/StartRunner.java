package com.example.myProject.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StartRunner implements ApplicationRunner {
    private final StartUtil startUtil;


    public StartRunner(StartUtil startUtil) {
        this.startUtil = startUtil;
    }

    @Override
    public void run(ApplicationArguments args) {
        startUtil.logStartInfo();
    }

}
