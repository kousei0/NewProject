package com.example.myProject.config;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
public class StartUtil {

    private final ApplicationContext applicationContext;

    public StartUtil(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void logStartInfo() {

        // 打印启动信息
        String serverPort = applicationContext.getEnvironment().getProperty("server.port", "8080");
        String serverPath = applicationContext.getEnvironment().getProperty("server.servlet.context-path", "");

        Set<String> set = NetUtil.localIpv4s();
        String localIp = NetUtil.LOCAL_IP;
        for (String s : set) {
            // 不使用本机地址，也不使用本机网关地址
            if (!localIp.equals(s) && !s.endsWith(".1")) {
                localIp = s;
                break;
            }
        }
        String apiUrl = String.format("http://%s:%s%s", localIp, serverPort, serverPath);

        log.info("application swagger started at    {}/doc.html#plus", apiUrl);
        log.info("application start successful!");

        /*
         * 注册shutdown钩子，当应用程序正常关闭时，会调用这里的方法
         * kill -9时，不会触发这段代码
         */
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("stop application successfully");
        }));
    }
}
