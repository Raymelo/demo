package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author ziqin.lei
 * @since 2019-03-25
 */
@Slf4j
@RestController
@RequestMapping("deferred")
public class DeferredController {

    private DeferredResult<String> deferredResult = new DeferredResult<>();

    @RequestMapping("get")
    public DeferredResult<String> get() {
        log.info("get begin");
        return deferredResult;
    }

    @RequestMapping("set")
    public String set() {
        log.info("set begin");
        deferredResult.setResult("set result!");
        return "succeed";
    }
}
