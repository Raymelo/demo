package com.example.demo.controller;

import com.example.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ziqin.lei
 * @since 2018/5/23
 */
@RestController
@RequestMapping("future")
public class FutureController {
    private static final Logger logger = LoggerFactory.getLogger(FutureController.class);
    private static final Map<String, CompletableFuture<String>> FUTURE_MAP = new ConcurrentHashMap<>();

    @GetMapping("test1")
    public CompletableFuture<String> test1() {
        CompletableFuture<String> future1 = new CompletableFuture<>();
        logger.info("future1:{}", JsonUtil.defaultGson().toJson(future1));
        return future1;
    }

    @GetMapping("test2")
    public CompletableFuture<String> test2() {
        CompletableFuture<String> future2 = new CompletableFuture<>();
        String id = UUID.randomUUID().toString();
        logger.info("id:{}", id);
        FUTURE_MAP.put(id, future2);
        logger.info("future2:{}", JsonUtil.defaultGson().toJson(future2));
        return future2;
    }

    /**
     * 每10秒执行一次
     */
    @Scheduled(fixedRate = 10000)
    public void update() {
        logger.info("update begin");
        Iterator<Map.Entry<String, CompletableFuture<String>>> iterator = FUTURE_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, CompletableFuture<String>> next = iterator.next();
            CompletableFuture<String> future = next.getValue();
            future.complete(next.getKey());
            iterator.remove();
        }
    }
}
