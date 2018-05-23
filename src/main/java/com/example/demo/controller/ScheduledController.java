package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ziqin.lei
 * @since 2018/5/23
 */
@RestController
@RequestMapping("schedule")
public class ScheduledController {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledController.class);

    /**
     * 每10秒执行一次
     */
    @Scheduled(fixedRate = 10000)
    public void test1() {
        logger.info("test1 begin, use fixedRate");
    }

    /**
     * 每五秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void test2() {
        logger.info("test2 begin, use cron");
    }
}
