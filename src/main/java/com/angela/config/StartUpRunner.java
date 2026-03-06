package com.angela.config;

import com.angela.service.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpRunner implements ApplicationRunner {

    @Autowired
    private DownLoadService downLoadService;

    @Override
    public void run(ApplicationArguments args) {
        // 系统启动时调用
        downLoadService.retryProcessingTask();
    }
}
