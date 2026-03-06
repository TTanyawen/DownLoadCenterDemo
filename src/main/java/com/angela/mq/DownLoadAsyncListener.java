package com.angela.mq;


import com.angela.service.DownLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DownLoadAsyncListener {

    @Autowired
    private DownLoadService downLoadService;

    @RabbitListener(queues = "download.async.queue")
    public void processCacheRetryMessage(Long taskId) {
        log.info("开始处理异步任务：{}", taskId);
        downLoadService.exportUserOlderThen18Async_consumer(taskId);
    }
}
