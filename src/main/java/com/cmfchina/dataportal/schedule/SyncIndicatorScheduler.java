package com.cmfchina.dataportal.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SyncIndicatorScheduler {

    private static final Logger log = LoggerFactory.getLogger(SyncIndicatorScheduler.class);

    // 每5秒执行一次
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("当前时间: {}", new Date());
    }

    // 使用cron表达式（每天早上8点执行）
    @Scheduled(cron = "0 0 8 * * ?")
    public void scheduledTask() {
        // 你的任务逻辑
    }
}
